package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.model.Song;

public class SearchResultsPage extends AbstractPage {

    private Song song;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "(//search-result-item//a)[1]")
    private WebElement requiredSongCard;

    public SearchResultsPage(WebDriver driver, Song song)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
        this.song = song;
    }

    public SongTextPage navigateToSongTextPage() {
        requiredSongCard.click();
        logger.info("Navigate to song text page");
        return new SongTextPage(driver, song);
    }

    public Song getSong() {
        return song;
    }

    @Override
    public SearchResultsPage openPage()
    {
        logger.info("Search results page opened");
        return this;
    }
}
