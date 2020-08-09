public class Student extends Person implements Comparable<Person> {

    public Student(String name, String academicLevel) {
        super(name, academicLevel.toUpperCase() + "_STUDENT");
    }

    @Override
    public int compareTo(Person person) {
        return this.getDesignation().compareTo(person.getDesignation());
    }
}
