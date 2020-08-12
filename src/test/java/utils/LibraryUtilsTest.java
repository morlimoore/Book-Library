package utils;

import models.Book;
import models.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUtilsTest {

    LibraryUtils libraryUtils;
    Book book1;
    Book book2;
    Book book3;

    @BeforeEach
    void setUp() {
        libraryUtils = new LibraryUtils();
        book1 = new Book("Intro to Java", "Prof. Ikebobo", 50);
        book2 = new Book("Understanding OOP", "Engr. Morlimoore", 35);
        book3 = new Book("Algorithms", "Prof. Ikebobo", 90);
    }

    @Test
    @DisplayName("Is book added correctly")
    void addBookToCatalogue() {
        libraryUtils.addBookToCatalogue(book1, 2);
        libraryUtils.addBookToCatalogue(book2, 3);

        assertEquals(libraryUtils.getTotalNoOfBooksInCatalogue(), 5);
    }

    @Test
    @DisplayName("Can read accurate record of books")
    void getTotalNoOfBooksInCatalogue() {
        libraryUtils.addBookToCatalogue(book1, 1);
        assertNotNull(libraryUtils.getTotalNoOfBooksInCatalogue());
    }

    @Test
    @DisplayName("Can read accurate record of books")
    void returnBook() {
        libraryUtils.addBookToCatalogue(book1, 1);
        libraryUtils.returnBook(book1.getId(), book1);
        assertEquals(libraryUtils.getCatalogue().get(book1.getId()).keySet().toArray()[0], book1);
    }

    @Test
    @DisplayName("Can read the entire catalogue")
    void getCatalogue() {
        libraryUtils.addBookToCatalogue(book1, 1);
        assertNotNull(libraryUtils.getCatalogue());
    }
}