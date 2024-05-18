package framework.test;

import framework.model.User;
import framework.page.LoginPage;
import framework.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserAccessTests extends CommonConditions {
    @Test
    public void oneCanLoginGenius() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new LoginPage(driver)
                .openPage()
                .login(testUser);
    }
}