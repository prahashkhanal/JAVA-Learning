import java.util.*;

abstract class LibraryItem {
    private String itemId;
    private String title;
    protected boolean isReserved;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
        this.isReserved = false;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public void showDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title);
    }

    public abstract void processLoan();
}

class TextBook extends LibraryItem {

    public TextBook(String itemId, String title) {
        super(itemId, title);
    }

    @Override
    public void processLoan() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Textbook '" + getTitle() + "' issued for 14 days.");
        } else {
            System.out.println("Error: '" + getTitle() + "' is already on loan.");
        }
    }
}

class ResearchPaper extends LibraryItem {

    public ResearchPaper(String itemId, String title) {
        super(itemId, title);
    }

    @Override
    public void processLoan() {
        System.out.println("Generating secure PDF download link...");
    }
}

public class casefour {
    public static void main(String[] args) {

        TextBook book = new TextBook("B101", "Java Core");
        book.processLoan();

        book.processLoan();

        LibraryItem paper = new ResearchPaper("R99", "AI Ethics");
        paper.processLoan();

    }
}