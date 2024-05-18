package framework.test;

import framework.model.Song;
import framework.model.User;
import framework.page.LoginPage;
import framework.page.MainPage;
import framework.service.SongCreator;
import framework.service.UserCreator;
import org.testng.annotations.Test;

public class SearchSongTextTests extends CommonConditions {
    Song testSong = SongCreator.withCredentialsFromProperty();
    @Test
    public void searchSongByNameAndAuthor() {
        new MainPage(driver)
                .openPage()
                .searchSong(testSong)
                .navigateToSongTextPage();
    }
}
