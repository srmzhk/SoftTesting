package framework.page;

import framework.model.Song;
import framework.util.LocatorCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    public VideoPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public VideoPage openPage()
    {
        logger.info("Video page opened");
        return this;
    }
}
