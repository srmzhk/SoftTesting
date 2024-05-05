package lab10.test;

import lab10.page.GeniusHomePage;
import lab10.page.LoginPage;
import lab10.page.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchSongTextByName() {
        new GeniusHomePage(driver)
                .openPage()
                .searchSongByName("The Hills")
                .openSongTextPage();
    }

    @Test
    public void searchSongTextByNameAndOpenExplanationForTextLine() {
        new GeniusHomePage(driver)
                .openPage()
                .searchSongByName("The Hills")
                .openSongTextPage()
                .openExplanationForTextLine("man on the road");
    }

    @Test
    public void loginWithCredentials() {
        new GeniusHomePage(driver)
                .openPage()
                .toLoginPage()
                .loginWithCredentials("srmzhk", "133464213St");
    }

    @Test
    public void readMessageFromSomeone() {
        new GeniusHomePage(driver)
                .openPage()
                .toLoginPage()
                .loginWithCredentials("srmzhk", "133464213St")
                .openMessages()
                .openChatWith("Genius");
    }

    @AfterTest(alwaysRun = true)
    public void browserShutdown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        driver = null;
    }
}
