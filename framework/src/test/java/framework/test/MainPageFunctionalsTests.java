package framework.test;

import framework.page.MainPage;
import org.testng.annotations.Test;

public class MainPageFunctionalsTests extends CommonConditions{
    @Test
    public void readNews() {
        new MainPage(driver)
                .openPage()
                .openNews();
    }

    @Test
    public void watchCharts() {
        new MainPage(driver)
                .openPage()
                .navigateToCharts();
    }

    @Test
    public void watchVideo() {
        new MainPage(driver)
                .openPage()
                .navigateToVideoPage();
    }
}
