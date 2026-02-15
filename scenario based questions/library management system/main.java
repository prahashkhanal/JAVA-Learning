import java.util.*;

class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    Book searchByTitle(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    void displayAllBooks() {
        for (Book b : books) {
            b.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book("Java Basics", "James Gosling", "101"));
        lib.addBook(new Book("OOP Concepts", "Bjarne", "102"));

        lib.displayAllBooks();

        Book found = lib.searchByTitle("Java Basics");
        if (found != null)
            found.display();
        else
            System.out.println("Book not found");
    }
}
