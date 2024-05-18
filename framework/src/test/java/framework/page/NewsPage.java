package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewsPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    public NewsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public NewsPage openPage()
    {
        logger.info("News page opened");
        return this;
    }
}
