package utils;

import models.Book;
import models.Library;
import models.Person;

import java.util.Map;
import java.util.Queue;

public class Queueing {

    /**
     * Handles all queueing functionality in the project.
     * Enables the users lend a book from the library.
     * It should be instantiated as soon as a Library object is created.
     */

    private Library library = new Library();
    private Person person = new Person();
    private Priority priority = new Priority();

    /**
     * Enlists the user (intending borrower) for request processing
     * @param person
     * @param bookToLend
     */
    public void standInQueue(Person person, Book bookToLend) {
        person.setIdOfBookToBorrow(bookToLend.getId());
        joinNormalLendingQueue(person);
        joinPriorityLendingQueue(person);
        priority.determinePriority(person, bookToLend);
    }

    /**
     * This enqueues the user in a no priority queue.
     * @param person
     */
    public void joinNormalLendingQueue(Person person) {
        library.getNormalQueue().add(person);
    }

    /**
     * This enqueues the user in a high priority queue.
     * @param person
     */
    public void joinPriorityLendingQueue(Person person) {
        library.getPriorityQueue().add(person);
    }

    /**
     * Initiates the processing method for the requests,
     * which utilises the priority queue
     */
    public void priorityProcessing() {
        System.out.println("Priority Queue processing" + "\n");
        processLendingRequest(library.getPriorityQueue());
    }

    /**
     * Initiates the processing method for the requests,
     * which utilises the no priority queue
     */
    public void normalProcessing() {
        System.out.println("Normal Queue processing" + "\n");
        processLendingRequest(library.getNormalQueue());
    }

    /**
     * This processes all users book lending requests,
     * in the appropriate queue due for processing.
     * It returns "Book taken" if book has been exhausted in the Library (Catalogue).
     * @param queue
     */
    public void processLendingRequest(Queue<Person> queue) {
        try {
            while (true) {
                Person person = queue.poll();
                if (person == null)
                    return;
                else {
                    if (person.getIdOfBookToBorrow() == null || !library.getCatalogue().containsKey(
                            person.getIdOfBookToBorrow())) {
                        System.out.println(person.getName() + " => Book taken" + "\n");
                        continue;
                    }
                    int value = 0;
                    for (Integer i : library.getCatalogue().get(person.getIdOfBookToBorrow()).values()) {
                        value = i;
                    }
                    Book tempBook = new Book();
                    for (Book b : library.getCatalogue().get(person.getIdOfBookToBorrow()).keySet()) {
                        tempBook = b;
                    }
                    Map<Book, Integer> tempMap = Map.of(tempBook, --value);
                    library.getCatalogue().replace(person.getIdOfBookToBorrow(), tempMap);
                    System.out.println(tempBook.getTitle() + " has been lent to " + person.getName() + "\n");
                    if (value < 1)
                        library.getCatalogue().remove(person.getIdOfBookToBorrow());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
