import models.Book;
import models.Librarian;
import models.Library;
import models.Person;
import utils.Queueing;

/**
 * The program is run here. Firstly, we instantiate the Library, the Librarian,
 * and then the Queueing.
 */

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Librarian librarian = new Librarian();
        Queueing queueing = new Queueing();

        //Create the Person objects: Teacher, Senior students and Junior students.
        Person teacher = new Person("Teacher Ike bobo", "teacher");
        Person teacher2 = new Person("Teacher Kaito", "teacher");
        Person teacher3 = new Person("Teacher Zurum", "teacher");
        Person studentSenior = new Person("Senior Std Ike", "senior_student");
        Person studentSenior2 = new Person("Senior Std Chi", "senior_student");
        Person studentJunior = new Person("Junior Std Ike", "junior_student");
        Person studentJunior2 = new Person("Junior Std Buike", "junior_student");

        //Create the Book objects.
        Book book1 = new Book("Intro to Java", "Prof. Ikebobo", 50);
        Book book2 = new Book("Understanding OOP", "Engr. Morlimoore", 35);
        Book book3 = new Book("Algorithms", "Prof. Ikebobo", 90);
        Book book4 = new Book("Algorithms", "Prof. Victor", 90);
        Book book5 = new Book("Greatness", "Ikenna", 30);

        //Use the librarian to add the created books to the Library (Catalogue).
        librarian.addBookToLibrary(book1, 60);
        librarian.addBookToLibrary(book2, 2);
        librarian.addBookToLibrary(book3, 5);
//        librarian.addBookToLibrary(book4, 5);

        library.viewCatalogue();
//        library.getTotalNoOfBooksInCatalogue();
        library.getTotalNoOfBooksInCatalogue();

        //The person looks through the catalogue, selects his/her choice of book to be borrowed,
        //and stands in queue with the book. Processing is First Come First Serve, priority processing
        // is triggered when a teacher requests for the same book as a student.
        queueing.standInQueue(studentJunior, book1);
//        queueing.standInQueue(studentSenior, book2);
//        queueing.standInQueue(teacher, book3);
        queueing.standInQueue(studentJunior, book1);
        queueing.standInQueue(teacher, book2);
//        queueing.standInQueue(teacher3, book1);

        //It is the job of the Librarian to process the borrowing requests
        librarian.processBorrowingRequests();

        library.getTotalNoOfBooksInCatalogue();

        //A person can return any book to the library
        teacher.returnBookToLibrary(book2);

        library.getTotalNoOfBooksInCatalogue();
    }
}
