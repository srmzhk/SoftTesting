package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class AddSongTextPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@id='main']//h1")
    private WebElement failedAccessText;

    public AddSongTextPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean checkAccess() {
        logger.info("Checking user IQ for access");
        return !Objects.equals(failedAccessText.getText(), "You need 100 IQ to add a song");
    }

    @Override
    public AddSongTextPage openPage()
    {
        logger.info("Add song text page opened");
        return this;
    }
}
