public class Main {
    public static void main(String[] args) {
        Library library = new Library();
            Teacher teacher1 = new Teacher("TeacherIkebobo");
            Teacher teacher2 = new Teacher("TeacherMorlimoore");

            Student studentSenior1 = new Student("IkeboboSenior1", "senior");
            Student studentSenior2 = new Student("IkeboboSenior2", "senior");

            Student studentJunior1 = new Student("IkeboboJunior1", "junior");
            Student studentJunior2 = new Student("IkeboboJunior2", "junior");

            Book book1 = new Book("Intro to Java", "Prof. Ikebobo", 50);
            Book book2 = new Book("Understanding OOP", "Engr. Morlimoore", 35);
            Book book3 = new Book("Algorithms", "Prof. Ikebobo", 90);


            library.addBookToCatalogue(book1, 5);
            library.addBookToCatalogue(book2, 4);
            library.addBookToCatalogue(book3, 9);

            library.getTotalNoOfBooksInCatalogue();

            library.viewCatalogue();

            studentJunior1.seekToLendBook("Understanding OOP");
            studentSenior1.seekToLendBook("Understanding OOP");
            teacher1.seekToLendBook("Understanding OOP");
//            studentSenior2.seekToLendBook("Science of Magic");

//            library.processLendingRequest1();

            library.processLendingRequest2();

            library.getTotalNoOfBooksInCatalogue();

            library.viewCatalogue();


    }
}
