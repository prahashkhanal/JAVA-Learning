import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(String isbn, String title, String author, boolean isAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s | Title: %s | Author: %s | Status: %s",
                isbn,
                title,
                author,
                isAvailable ? "Available" : "Checked Out");
    }
}

class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Success!");
                } else {
                    System.out.println("Sorry, this book is currently checked out.");
                }
                return;
            }
        }
        System.out.println("Unavailable.");
    }

    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                book.setAvailable(true);
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayAvailableBooks() {
        boolean foundAvailable = false;
        System.out.println("\n--- Available Books ---");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                foundAvailable = true;
            }
        }
        if (!foundAvailable) {
            System.out.println("No books are currently available.");
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library has no books.");
            return;
        }

        System.out.println("\n--- All Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        initializeDefaultBooks(library);

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    library.displayAllBooks();
                    break;
                case "2":
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine().trim();
                    library.borrowBook(isbn);
                    break;
                case "3":
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static void initializeDefaultBooks(Library library) {
        library.addBook(new Book("978-01", "The Little River", "Mira Cole", true));
        library.addBook(new Book("978-02", "Java for Beginners", "Liam West", true));
        library.addBook(new Book("978-03", "Quiet Town Stories", "Nora Hale", true));
    }

    private static void printMenu() {
        System.out.println("\n====== The Digital Bookshelf ======");
        System.out.println("1) See All Books");
        System.out.println("2) Borrow Book");
        System.out.println("3) Exit");
        System.out.print("Enter your choice: ");
    }
}
