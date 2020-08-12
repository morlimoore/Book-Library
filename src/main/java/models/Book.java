package models;

public class Book {
    private String id;
    private String title;
    private String author;
    private int noOfPages;

    public Book(){}

    /**
     * Creates Book objects
     * @param title
     * @param author
     * @param noOfPages
     */

    public Book(String title, String author, int noOfPages) {
        this.title = title;
        this.author = author;
        this.noOfPages = noOfPages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    @Override
    public String toString() {
        return "models.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", noOfPages=" + noOfPages +
                '}';
    }
}
