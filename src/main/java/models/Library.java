package models;

import utils.LibraryUtils;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Library {
    private static Queue<Person> priorityQueue = new PriorityQueue<>();
    private static Queue<Person> normalQueue = new LinkedList<>();
    private LibraryUtils libraryUtils = new LibraryUtils();

    /**
     * This presents all functionality accorded by this Library to the user.
     * Functions includes:
     * Add a book to the catalogue
     * View the catalogue
     * Get the total number of books in the catalogue
     * Receive a book returned to the library
     */
    public Library() {}

    public void addBookToCatalogue(Book book, Integer quantity) {
            libraryUtils.addBookToCatalogue(book, quantity);
    }

    public void viewCatalogue() {
        System.out.println("Catalogue: " + libraryUtils.getCatalogue() + "\n");
    }

    public void getTotalNoOfBooksInCatalogue() {
        libraryUtils.getTotalNoOfBooksInCatalogue();
    }

    public void returnBook(String bookId, Book book) {
        libraryUtils.returnBook(bookId, book);
    }

    public Map<String, Map<Book, Integer>> getCatalogue2() {
        return libraryUtils.getCatalogue();
    }

    public static Queue<Person> getPriorityQueue() {
        return priorityQueue;
    }

    public static Queue<Person> getNormalQueue() {
        return normalQueue;
    }
}

