public class Person {
    private enum Designation{
        TEACHER, SENIOR_STUDENT, JUNIOR_STUDENT
    }

    private String name;
    private String designation;
    private String bookToLend;

    public Person() {};

    public Person(String name, String designation) {
        this.name = name;
        this.designation = designation.toUpperCase();
    }

    public void seekToLendBook(String bookName) {
        bookToLend = bookName;
        Library library = new Library();
        library.joinLendingQueue(this);
    }

    public String getName() {
//        System.out.println(designation + "'s name is " + name);
        return name;
    }

//    public String getDesignation() {
//        return designation;
//    }

    public String getBookToLend() {
        return bookToLend;
    }

    public Integer getDesignation() {
        return Designation.valueOf(designation).ordinal();
    }

    public void getRanking() {
        System.out.println("A " + designation + " is ranked: " + Designation.valueOf(designation).ordinal() + "\n");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
