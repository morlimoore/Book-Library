package models;

public class Person implements Comparable<Person> {

    private String id;
    private String name;
    private String status;
    private String idOfBookToLend;
    private Library library = new Library();

    private enum Designation{
        TEACHER, SENIOR_STUDENT, JUNIOR_STUDENT
    }

    public Person() {}

    /**
     * Generic person class.
     * Other players; Teachers and Students are created from this class.
     * This is achieved by supplying the appropriate status for each object.
     * Provide:
     * "TEACHER" for a teacher object
     * "SENIOR_STUDENT" for a senior student object
     * "JUNIOR_STUDENT" for a junior student object
     * @param name
     * @param status
     */

    public Person(String name, String status) {
        this.name = name;
        this.status = status.toUpperCase();
    }

    public Integer getDesignation() {
        return Designation.valueOf(status).ordinal();
    }

    public void returnBookToLibrary(Book bookToReturn) {
        library.returnBook(bookToReturn.getId(), bookToReturn);
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getIdOfBookToLend() {
        return idOfBookToLend;
    }

    public void setIdOfBookToLend(String idOfBookToLend) {
        this.idOfBookToLend = idOfBookToLend;
    }

    @Override
    public int compareTo(Person person) {
        return this.getDesignation().compareTo(person.getDesignation());
    }

    @Override
    public String toString() {
        return "models.Person{" +
                "name='" + name + '\'' +
                ", designation='" + status + '\'' +
                '}';
    }
}
