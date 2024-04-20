package org.srmzhk.lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest {
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchSongText() throws InterruptedException {
        driver.get("https://genius.com/Post-malone-rockstar-lyrics");
        WebElement searchText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lyrics-root\"]/div[2]/a[4]")));
        scrollToElement(driver, searchText);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchText));
        searchText.click();
        Thread.sleep(5000);
    }

    @Test
    public void searchAndWatchVideo() throws InterruptedException {
        driver.get("https://genius.com/");
        WebElement videoButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"application\"]/div/div[2]/a[3]")));
        videoButton.click();
        WebElement searchVideo = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"videos\"]/div/a")));
        searchVideo.click();
        Thread.sleep(10000);
    }

    @Test
    public void searchAndReadFirstMostPopularSongText() throws InterruptedException {
        driver.get("https://genius.com/");
        WebElement chartsButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"application\"]/div/div[2]/a[1]")));
        chartsButton.click();
        WebElement firstSong = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top-songs\"]/div/div[2]/a[1]")));
        firstSong.click();
        Thread.sleep(10000);
    }

    @AfterMethod (alwaysRun = true)
    public void browserShutdown(){
        driver.quit();
    }
}
