package framework.util;

import framework.service.TestDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorCreator {
    private static String defaultStringForSearchTextLocator = "//a[./span[contains(text(), 'textLine')]]";
    private static String defaultChatCardString = "//div[./div[text()='username']]";
    private static String chatUsername = TestDataReader.getTestData("testdata.chat.username");

    public static By buildTextLineLocator (String text) {
        String stringForTextLocator = defaultStringForSearchTextLocator.replaceFirst("textLine", text);
        return By.xpath(stringForTextLocator);
    }

    public static By buildLocatorForChatWithUser() {
        String chatCardString = defaultChatCardString.replaceFirst("username", chatUsername);
        return By.xpath(chatCardString);
    }
}
