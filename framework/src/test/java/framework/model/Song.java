package framework.model;

public class Song {
    private String name;
    private String author;
    private String fullName;
    private String searchText;

    public Song(String name, String author, String searchText) {
        this.name = name;
        this.author = author;
        this.fullName = name + " - " + author;
        this.searchText = searchText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
