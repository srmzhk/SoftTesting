package framework.test;

import framework.page.LoginPage;
import framework.page.MainPage;
import framework.service.UserCreator;
import framework.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizeUserTests extends CommonConditions {
    User user = UserCreator.withCredentialsFromProperty();
    @Test
    public void addNewSongText() {
        Assert.assertTrue(
                new LoginPage(driver)
                .openPage()
                .login(user)
                .navigateToMainPage()
                .navigateToAddSongTextPage()
                .checkAccess()
        );
    }

    @Test
    public void readMessagesFromSomeone() {
        new LoginPage(driver)
                .openPage()
                .login(user)
                .navigateToMainPage()
                .openMessages()
                .openChatWith();
    }

    @Test
    public void subscribeForMusicForum() {
        new LoginPage(driver)
                .openPage()
                .login(user)
                .navigateToMainPage()
                .navigateToForumsPage()
                .followForMusicForum();
    }

    @Test
    public void changeAccountInfo() {
        new LoginPage(driver)
                .openPage()
                .login(user)
                .editProfile();
    }
}
