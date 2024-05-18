package framework.test;

import framework.model.Song;
import framework.page.MainPage;
import framework.service.SongCreator;
import org.testng.annotations.Test;

public class SearchExplanationTests extends CommonConditions {
    Song testSong = SongCreator.withCredentialsFromProperty();
    @Test
    public void searchExplanationInSongByText() {
        new MainPage(driver)
                .openPage()
                .searchSong(testSong)
                .navigateToSongTextPage()
                .openExplanationForTextLine();
    }
}
