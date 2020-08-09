import java.util.*;

public class Library {

    private Map<String, Integer> catalogue = new TreeMap<>();
    private static Queue<Person> priorityQueue = new PriorityQueue<Person>();
    private static Queue<Person> queue = new LinkedList<Person>();

    public Library () {}

    public void addBookToCatalogue(Book book, Integer quantity) {
        catalogue.put(book.getTitle(), quantity);
    }

    public void viewCatalogue() {
        System.out.println("Catalogue: " + catalogue + "\n");
    }

    public void getTotalNoOfBooksInCatalogue() {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : catalogue.entrySet()) {
            sum += entry.getValue();
        }
        System.out.println("Total number of books in the library is: " + sum + "\n");
    }

    public void joinLendingQueue(Person person) {
        priorityQueue.add(person);
        queue.add(person);
//        System.out.println("Lending queue: " + person + " wants to lend " + person.getBookToLend() + "\n");
    }

    public void peekHeadOfQueue() {
        System.out.println("Head of PriorityQueue: " + priorityQueue.peek() + "\n");
    }

    public void processLendingRequest1() {
        try {
            while (true) {
                Person person = priorityQueue.poll();
                if (person == null)
                    break;

//            System.out.println("Processing lending request: " + person);

                if (catalogue.get(person.getBookToLend()) == null) {
                    System.err.println("Book taken" + "\n");
                } else {
                    catalogue.replace(person.getBookToLend(), catalogue.get(person.getBookToLend()) - 1);
                    System.out.println(person.getBookToLend() + " has been lent to " + person.getName() + "\n");
                    if (catalogue.get(person.getBookToLend()) < 1)
                        catalogue.remove(person.getBookToLend());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processLendingRequest2() {
        try {
            while (true) {
                Person person = queue.poll();
                if (person == null)
                    break;

//            System.out.println("Processing lending request: " + person);

                if (catalogue.get(person.getBookToLend()) == null) {
                    System.err.println("Book taken" + "\n");
                } else {
                    catalogue.replace(person.getBookToLend(), catalogue.get(person.getBookToLend()) - 1);
                    System.out.println(person.getBookToLend() + " has been lent to " + person.getName() + "\n");
                    if (catalogue.get(person.getBookToLend()) < 1)
                        catalogue.remove(person.getBookToLend());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
