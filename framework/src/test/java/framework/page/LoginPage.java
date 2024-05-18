package framework.page;

import framework.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.Main;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private static final String PAGE_URL = "https://genius.com/login";
	private static final String HOME_URL = "https://genius.com";

	@FindBy(id = "user_session_login")
	private WebElement inputLogin;

	@FindBy(id = "user_session_password")
	private WebElement inputPassword;

	@FindBy(id = "user_session_submit")
	private WebElement buttonSubmit;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public LoginPage openPage()
	{
		driver.navigate().to(PAGE_URL);
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(webDriver -> ((JavascriptExecutor) webDriver)
						.executeScript("return document.readyState")
						.equals("complete"));
		logger.info("Login page opened");
		return this;
	}

	public AccountPage login(User user)
	{
		inputLogin.sendKeys(user.getUsername());
		logger.info("Input username");
		inputPassword.sendKeys(user.getPassword());
		logger.info("Input password");
		buttonSubmit.click();
		logger.info("Login performed");
		return new AccountPage(driver);
	}

	public MainPage navigateToMainPage() {
		logger.info("Navigate to main page");
		driver.navigate().to(HOME_URL);
		return new MainPage(driver);
	}
}
