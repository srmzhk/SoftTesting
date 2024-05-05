package lab10.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeniusHomePage {
    private static final String HOMEPAGE_URL = "https://genius.com";
    private final By loginButtonLocator = By.xpath("(//a[@href='/login'])[1]");
    private final By messagesButtonLocator = By.xpath("//div[./div[./span[text()='Messages']]]");
    private final By messagesIframeLocator = By.xpath("//iframe[@src='/inboxes/messages_inbox?embed=true']");
    private final By searchInputLocator = By.cssSelector("input");
    private final By searchButtonLocator = By.xpath("//form[@action='/search']//div[2]");
    private final String defaultChatCardString = "//div[./div[text()='username']]";
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private WebDriver driver;
    private By chatCardLocator = By.xpath("");

    public GeniusHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public GeniusHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        return this;
    }

    public LoginPage toLoginPage() {
        WebElement loginButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator));
        loginButton.click();
        return new LoginPage(driver);
    }

    public SearchResultsPage searchSongByName(String songName) {
        WebElement searchInput =  new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchInputLocator));
        searchInput.sendKeys(songName);

        WebElement searchButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchButtonLocator));
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public GeniusHomePage openMessages() {
        WebElement messagesButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(messagesButtonLocator));
        messagesButton.click();
        return this;
    }

    public GeniusHomePage openChatWith(String username) {
        WebElement messagesIframe = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(messagesIframeLocator));
        driver.switchTo().frame(messagesIframe);

        buildLocatorForChatWithUser(username);
        WebElement chatCard = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(chatCardLocator));
        chatCard.click();
        return this;
    }

    private void buildLocatorForChatWithUser(String username) {
        String chatCardString = defaultChatCardString.replaceFirst("username", username);
        chatCardLocator = By.xpath(chatCardString);
    }
}
