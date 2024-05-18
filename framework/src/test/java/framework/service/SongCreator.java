package framework.service;

import framework.model.Song;

public class SongCreator {

    public static final String TESTDATA_SONG_NAME = "testdata.song.name";
    public static final String TESTDATA_SONG_AUTHOR = "testdata.song.author";
    public static final String TESTDATA_SONG_SEARCHTEXT = "testdata.song.searchtext";

    public static Song withCredentialsFromProperty(){
        return new Song(TestDataReader.getTestData(TESTDATA_SONG_NAME),
                TestDataReader.getTestData(TESTDATA_SONG_AUTHOR),
                TestDataReader.getTestData(TESTDATA_SONG_SEARCHTEXT));
    }

    public static Song withEmptySongName(){
        return new Song("", TestDataReader.getTestData(TESTDATA_SONG_AUTHOR),
                TestDataReader.getTestData(TESTDATA_SONG_SEARCHTEXT));
    }

    public static Song withEmptyAuthor(){
        return new Song(TestDataReader.getTestData(TESTDATA_SONG_NAME), "",
                TestDataReader.getTestData(TESTDATA_SONG_SEARCHTEXT));
    }

    public static Song withEmptySearchText(){
        return new Song(TestDataReader.getTestData(TESTDATA_SONG_NAME),
                TestDataReader.getTestData(TESTDATA_SONG_AUTHOR), "");
    }
}
