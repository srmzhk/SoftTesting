package framework.page;

import framework.service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String HOME_URL = "https://genius.com";

    @FindBy(xpath = "//div[text()=' Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//textarea")
    private WebElement annotation;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public AccountPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public AccountPage editProfile() {
        logger.info("Start editing");
        editButton.click();
        logger.info("Extract test data annotation");
        String textAnnotation = TestDataReader.getTestData("testdata.account.annotation");
        logger.info("Cleaning annotation");
        annotation.clear();
        logger.info("Input annotation");
        annotation.sendKeys(textAnnotation);
        logger.info("Save changes");
        saveButton.click();
        return this;
    }

    public MainPage navigateToMainPage() {
        logger.info("Navigate to main page");
        driver.navigate().to(HOME_URL);
        return new MainPage(driver);
    }

    @Override
    public AccountPage openPage()
    {
        logger.info("Account page opened");
        return this;
    }
}
