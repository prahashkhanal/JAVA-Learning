import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

interface Taxable {
    double calculateTax();
}

abstract class Item implements Taxable {
    private final String itemID;
    private final String name;
    private final double basePrice;

    protected Item(String itemID, String name, double basePrice) {
        this.itemID = itemID;
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPriceIncludingTax() {
        return basePrice + calculateTax();
    }

    public abstract String getTypeDetails();

    @Override
    public String toString() {
        return String.format(
                "ID: %s | Name: %s | Base Price: $%.2f | Tax: $%.2f | Final Price: $%.2f | %s",
                itemID,
                name,
                basePrice,
                calculateTax(),
                getPriceIncludingTax(),
                getTypeDetails()
        );
    }
}

class PerishableItem extends Item {
    private final LocalDate expiryDate;

    public PerishableItem(String itemID, String name, double basePrice, LocalDate expiryDate) {
        super(itemID, name, basePrice);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public double calculateTax() {
        return getBasePrice() * 0.05;
    }

    @Override
    public String getTypeDetails() {
        return String.format("Type: Perishable | Expiry: %s | Status: %s",
                expiryDate,
                isExpired() ? "EXPIRED" : "Valid");
    }
}

class ElectronicItem extends Item {
    private final int warrantyPeriodMonths;

    public ElectronicItem(String itemID, String name, double basePrice, int warrantyPeriodMonths) {
        super(itemID, name, basePrice);
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    @Override
    public double calculateTax() {
        return getBasePrice() * 0.15;
    }

    @Override
    public String getTypeDetails() {
        return String.format("Type: Electronic | Warranty: %d months", warrantyPeriodMonths);
    }
}

class InventoryManager {
    private final HashMap<String, Item> inventory = new HashMap<>();

    public boolean addItem(Item item) {
        if (inventory.containsKey(item.getItemID())) {
            return false;
        }
        inventory.put(item.getItemID(), item);
        return true;
    }

    public Item searchById(String id) {
        return inventory.get(id);
    }

    public List<Item> getItemsSortedByBasePrice() {
        ArrayList<Item> items = new ArrayList<>(inventory.values());
        items.sort(Comparator.comparingDouble(Item::getBasePrice));
        return items;
    }

    public double totalInventoryValueInclTax() {
        double total = 0.0;
        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            total += entry.getValue().getPriceIncludingTax();
        }
        return total;
    }

    public void displayAllItems() {
        List<Item> sortedItems = getItemsSortedByBasePrice();
        if (sortedItems.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- Items in Warehouse (Sorted by Price) ---");
        for (Item item : sortedItems) {
            System.out.println(item);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addPerishableItem(scanner, manager);
                    break;
                case "2":
                    addElectronicItem(scanner, manager);
                    break;
                case "3":
                    manager.displayAllItems();
                    break;
                case "4":
                    searchItem(scanner, manager);
                    break;
                case "5":
                    System.out.printf("Total Inventory Value (Incl. Tax): $%.2f%n", manager.totalInventoryValueInclTax());
                    break;
                case "6":
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose from 1 to 6.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n====== LogistiTech Smart Warehouse ======");
        System.out.println("1) Add Perishable Item");
        System.out.println("2) Add Electronic Item");
        System.out.println("3) Display All Items");
        System.out.println("4) Search Item by ID");
        System.out.println("5) Calculate Total Inventory Value (Incl. Tax)");
        System.out.println("6) Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addPerishableItem(Scanner scanner, InventoryManager manager) {
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        double price = readPositiveDouble(scanner, "Enter Base Price: ");

        LocalDate expiry;
        while (true) {
            System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine().trim();
            try {
                expiry = LocalDate.parse(dateInput);
                break;
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        PerishableItem item = new PerishableItem(id, name, price, expiry);
        if (manager.addItem(item)) {
            System.out.println("Perishable item added successfully.");
        } else {
            System.out.println("Item ID already exists. Item not added.");
        }
    }

    private static void addElectronicItem(Scanner scanner, InventoryManager manager) {
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        double price = readPositiveDouble(scanner, "Enter Base Price: ");
        int warrantyMonths = readPositiveInt(scanner, "Enter Warranty Period (months): ");

        ElectronicItem item = new ElectronicItem(id, name, price, warrantyMonths);
        if (manager.addItem(item)) {
            System.out.println("Electronic item added successfully.");
        } else {
            System.out.println("Item ID already exists. Item not added.");
        }
    }

    private static void searchItem(Scanner scanner, InventoryManager manager) {
        System.out.print("Enter Item ID to search: ");
        String id = scanner.nextLine().trim();
        Item item = manager.searchById(id);

        if (item == null) {
            System.out.println("No item found with ID: " + id);
        } else {
            System.out.println("Item found:");
            System.out.println(item);
        }
    }

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please enter a valid positive number.");
        }
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please enter a valid positive integer.");
        }
    }
}
