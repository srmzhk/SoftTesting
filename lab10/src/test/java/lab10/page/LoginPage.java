package lab10.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static final String LOGINPAGE_URL = "https://genius.com/login";
    private final By loginInputLocator = By.id("user_session_login");
    private final By passwordInputLocator = By.id("user_session_password");
    private final By loginButtonLocator = By.id("user_session_submit");
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openPage() {
        driver.get(LOGINPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        return this;
    }

    public GeniusHomePage loginWithCredentials(String login, String password) {
        WebElement loginInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(loginInputLocator));
        loginInput.click();
        loginInput.sendKeys(login);

        WebElement passwordInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(passwordInputLocator));
        passwordInput.click();
        passwordInput.sendKeys(password);

        WebElement loginButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator));
        loginButton.click();
        return new GeniusHomePage(driver);
    }
}
