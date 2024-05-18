package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForumsPage extends  AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id=\"groups_home\"]/div[2]/div[2]/div[8]/div[2]/a")
    private WebElement musicForumButton;

    public ForumsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ForumsPage followForMusicForum() {
        musicForumButton.click();
        return this;
    }

    @Override
    public ForumsPage openPage()
    {
        logger.info("Forums page opened");
        return this;
    }
}
