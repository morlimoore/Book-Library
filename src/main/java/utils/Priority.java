package utils;

import models.Book;
import models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles all the priority allotments in the project.
 */
public class Priority {
    private static List<Book> comparableList = new ArrayList<>();
    private static boolean isPriorityRequired;

    /**
     * This accords priority to the Teacher, when he/she requests
     * for the same book requested for by the student.
     * @param person
     * @param bookToLend
     */
    public void determinePriority(Person person, Book bookToLend) {
        if (comparableList.size() != 0) {
            for (Book book : comparableList) {
                if (bookToLend.equals(book) && person.getStatus().equals("TEACHER"))
                    isPriorityRequired = true;
            }
        }
        comparableList.add(bookToLend);
    }

    public static boolean isPriorityRequired() {
        return isPriorityRequired;
    }

}
