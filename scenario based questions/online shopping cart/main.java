import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {
    List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(String productName) {
        products.removeIf(p -> p.name.equalsIgnoreCase(productName));
    }

    double calculateTotalCost() {
        double total = 0;
        for (Product p : products)
            total += p.price;
        return total;
    }

    void displayCart() {
        for (Product p : products)
            System.out.println(p.name + " - " + p.price);
        System.out.println("Total: " + calculateTotalCost());
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 500));

        cart.displayCart();
        cart.removeProduct("Mouse");
        cart.displayCart();
    }
}
