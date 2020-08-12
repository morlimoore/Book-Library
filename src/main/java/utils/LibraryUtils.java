package utils;

import models.Book;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.TreeMap;

public class LibraryUtils {

    /**
     * Bears all implementation detail of the Library class functions
     */

    //Data store for all the books, available in the library
    private static Map<String, Map<Book, Integer>> catalogue = new TreeMap<>();
    private static int bookCount = 0;

    /**
     * This adds books to the Library (catalogue)
     * It generates a unique ID for each collection of books added
     * to the Library.
     * @param book
     * @param quantity
     */
    public void addBookToCatalogue(Book book, Integer quantity) {

        //Formats the affixedNumber to be in double digit format
        NumberFormat numberFormat = new DecimalFormat("00");
        String affixedNumbers = numberFormat.format(++bookCount);

        //Builds a unique ID
        String id = (book.getTitle().substring(0, 3) + book.getAuthor().substring(
                book.getAuthor().length()-3, book.getAuthor().length()-1)
        ).toLowerCase().concat("x") + affixedNumbers;
        book.setId(id);

        Map<Book, Integer> tempMap = Map.of(book, quantity);
        catalogue.put(id, tempMap);
        System.out.println(book.getTitle() + " added to Catalogue with Book_ID: " + id + "\n");
    }

    /**
     * Prints total number of books in the Library (Catalogue).
     */
    public void getTotalNoOfBooksInCatalogue() {
        int totalNoOfBooks = 0;
        for (Map.Entry<String, Map<Book, Integer>> entry : catalogue.entrySet()) {
            for (Map.Entry<Book, Integer> entry2 : entry.getValue().entrySet()) {
                totalNoOfBooks += entry2.getValue();
            }
        }
        System.out.println("Total number of books in the library is: " + totalNoOfBooks + "\n");
    }

    /**
     * This returns a book to the Library (Catalogue).
     * @param bookId
     * @param book
     */
    public void returnBook(String bookId, Book book) {

        //Increments book quantity if the book exists in the catalogue, otherwise
        //it creates an entry for it, with a quantity of 1.
        if (catalogue.containsKey(bookId)) {
            Book tempBook = (Book) catalogue.get(bookId).keySet().toArray()[0];
            int quantity = (int) catalogue.get(bookId).values().toArray()[0];
            Map<Book, Integer> tempMap = Map.of(tempBook, ++quantity);
            catalogue.put(bookId, tempMap);
        } else {
            Map<Book, Integer> tempMap = Map.of(book, 1);
            catalogue.put(bookId, tempMap);
        }
        System.out.println(book.getTitle() + " has been returned to the library." + "\n");
    }

    public static Map<String, Map<Book, Integer>> getCatalogue() {
        return catalogue;
    }
}
