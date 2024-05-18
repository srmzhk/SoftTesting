package framework.page;

import framework.model.Song;
import framework.util.LocatorCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private static final String BASE_URL = "https://genius.com/";

	@FindBy(css = "input")
	private WebElement searchInput;

	@FindBy(xpath = "//form[@action='/search']//div[2]")
	private WebElement searchButton;

	@FindBy(xpath = "(//a//h2)[1]")
	private WebElement firstNewsCard;

	@FindBy(xpath = "//a[@href='/#top-songs']")
	private WebElement chartsButton;

	@FindBy(xpath = "//a[@href='/#top-songs']")
	private WebElement videosButton;

	@FindBy(xpath = "(//div[@id='videos']//a)[1]")
	private WebElement videoCard;

	private final By addSongButtonLocator = By.xpath("//a[@href='/new']");
	private final By forumsButtonLocator = By.xpath("//a//span[text()='Forums']");
	private final By messagesButtonLocator = By.xpath("//div[./div[./span[text()='Messages']]]");
	private final By messagesIframeLocator = By.xpath("//iframe[@src='/inboxes/messages_inbox?embed=true']");

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public SearchResultsPage searchSong(Song song) {
		logger.info("Start search");
		searchInput.sendKeys(song.getFullName());
		logger.info("Input text into search input");
		searchButton.click();
		logger.info("Navigate to search results page");
		return new SearchResultsPage(driver, song);
	}

	public NewsPage openNews() {
		logger.info("Navigate to news");
		firstNewsCard.click();
		return new NewsPage(driver);
	}

	public MainPage navigateToCharts () {
		logger.info("Navigate to charts");
		chartsButton.click();
		return this;
	}

	public VideoPage navigateToVideoPage() {
		logger.info("Navigate to videos");
		videosButton.click();
		logger.info("Open video");
		videoCard.click();
		return new VideoPage(driver);
	}

	public AddSongTextPage navigateToAddSongTextPage() {
		logger.info("Search add song button element");
		WebElement addSongButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.
						presenceOfElementLocated(addSongButtonLocator));
		addSongButton.click();
		logger.info("Navigate to add new song text page");
		return new AddSongTextPage(driver);
	}

	public ForumsPage navigateToForumsPage() {
		logger.info("Search forums button element");
		WebElement forumsButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.
						presenceOfElementLocated(forumsButtonLocator));
		logger.info("Navigate to forums page");
		forumsButton.click();
		return new ForumsPage(driver);
	}

	public MainPage openMessages() {
		logger.info("Search messages button element");
		WebElement messagesButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(messagesButtonLocator));
		logger.info("Open messages");
		messagesButton.click();
		return this;
	}

	public MainPage openChatWith() {
		logger.info("Search messages iframe");
		WebElement messagesIframe = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(messagesIframeLocator));
		logger.info("Switching to messages iframe");
		driver.switchTo().frame(messagesIframe);
		logger.info("Create locator for chat card");
		By chatCardLocator = LocatorCreator.buildLocatorForChatWithUser();
		logger.info("Search chat card element");
		WebElement chatCard = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(chatCardLocator));
		logger.info("Opening chat");
		chatCard.click();
		return this;
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Main page opened");
		return this;
	}
}
