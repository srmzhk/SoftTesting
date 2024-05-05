package lab10.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AccountPage {
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
}
