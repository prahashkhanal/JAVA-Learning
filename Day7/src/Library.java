import java.util.ArrayList;

class Library {
    ArrayList<Book> books = new ArrayList<>();

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
            System.out.println(b.title + " | " + b.author + " | " + b.isbn);
        }
    }
}
