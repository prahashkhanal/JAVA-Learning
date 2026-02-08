public class LibraryMain {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book("Java", "James Gosling", "101"));
        lib.addBook(new Book("Python", "Guido", "102"));

        lib.displayAllBooks();

        Book found = lib.searchByTitle("Java");
        if (found != null) {
            System.out.println("Found: " + found.title);
        }
    }
}
