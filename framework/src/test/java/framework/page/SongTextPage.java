package framework.page;

import framework.model.Song;
import framework.util.LocatorCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SongTextPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private Song song;

    public SongTextPage(WebDriver driver, Song song)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
        this.song = song;
    }

    public SongTextPage openExplanationForTextLine() {
        logger.info("Build a locator for explanation textline");
        WebElement textLine = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.
                        presenceOfElementLocated(LocatorCreator.buildTextLineLocator(song.getSearchText())));
        logger.info("Scroll to element");
        scrollToElement(driver, textLine);
        textLine.click();
        logger.info("Open explanation");
        return this;
    }

    public Song getSong() {
        return song;
    }

    @Override
    public SongTextPage openPage()
    {
        logger.info("Song text page opened");
        return this;
    }

    private void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
