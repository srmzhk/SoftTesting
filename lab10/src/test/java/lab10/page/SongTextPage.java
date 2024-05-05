package lab10.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SongTextPage {
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private String defaultStringForLocator = "//a[./span[contains(text(), 'textLine')]]";
    private WebDriver driver;

    public SongTextPage(WebDriver driver) {
        this.driver = driver;
    }

    public SongTextPage openExplanationForTextLine(String text) {
        By textLineLocator = buildTextLineLocator(text);
        WebElement textLine = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(textLineLocator));
        scrollToElement(driver, textLine);
        textLine.click();
        return this;
    }

    private By buildTextLineLocator (String text) {
        String stringForTextLocator = defaultStringForLocator.replaceFirst("textLine", text);
        return By.xpath(stringForTextLocator);
    }

    private void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
