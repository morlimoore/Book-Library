package models;

import utils.Priority;
import utils.Queueing;

public class Librarian {

    private Library library = new Library();
    private Queueing queueing = new Queueing();
    private Priority priority = new Priority();

    /**
     * Creates a Librarian object.
     * It accepts no parameters.
     * A Librarian can add a book to the Library (Catalogue), and
     * process users requests to borrow a book.
     */

    public Librarian() {}

    public void addBookToLibrary(Book book, Integer quantity) {
        library.addBookToCatalogue(book, quantity);
    }

    public void processBorrowingRequests() {
        if (priority.isPriorityRequired())
            queueing.priorityProcessing();
        else
            queueing.normalProcessing();
    }
}
