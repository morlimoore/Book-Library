public class Book {
    String title;
    String author;
    int noOfPages;

    public Book(String title, String author, int noOfPages) {
        this.title = title;
        this.author = author;
        this.noOfPages = noOfPages;
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

//    @Override
//    public String toString() {
//        return "Book{" +
//                "title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", noOfPages=" + noOfPages +
//                '}';
//    }


//    @Override
//    public String toString() {
//        return title;
//    }
}
