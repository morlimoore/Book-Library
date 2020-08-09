public class Teacher extends Person implements Comparable<Person>{

    public Teacher (String name) {
        super(name, "TEACHER");
    }

    @Override
    public int compareTo(Person person) {
        return this.getDesignation().compareTo(person.getDesignation());
    }
}
