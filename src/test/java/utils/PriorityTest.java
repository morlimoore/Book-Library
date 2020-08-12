package utils;

import models.Book;
import models.Library;
import models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityTest {
    Queueing queueing = new Queueing();
    Library library = new Library();

    @Test
    @DisplayName("When teacher should have priority")
    void determinePriority() {
        Person teacher = new Person("Teacher Ike bobo", "teacher");
        Person student1 = new Person("Student Kaito", "junior_student");
        Person student2 = new Person("Student Zurum", "senior_student");

        Book book1 = new Book("Intro to Java", "Prof. Ikebobo", 50);
        queueing.standInQueue(student1, book1);
        queueing.standInQueue(student2, book1);
        queueing.standInQueue(teacher, book1);

        assertEquals(library.getPriorityQueue().poll(), teacher);
    }

    @Test
    @DisplayName("When no priority: First Come, First Serve")
    void determinePriority2() {
        Person student1 = new Person("Student Kaito", "junior_student");
        Person student2 = new Person("Student Zurum", "senior_student");
        Person teacher = new Person("Teacher Ike bobo", "teacher");

        Book book1 = new Book("Intro to Java", "Prof. Ikebobo", 50);
        Book book2 = new Book("Understanding OOP", "Engr. Morlimoore", 35);

        queueing.standInQueue(student1, book1);
        queueing.standInQueue(student2, book1);
        queueing.standInQueue(teacher, book2);

        assertEquals(library.getNormalQueue().poll(), student1);
    }
}