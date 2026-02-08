import java.util.ArrayList;

class ShoppingCart {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }

    void removeProduct(String name) {
        products.removeIf(p -> p.name.equalsIgnoreCase(name));
    }

    double calculateTotalCost() {
        double total = 0;
        for (Product p : products) total += p.price;
        return total;
    }

    void displayCart() {
        for (Product p : products)
            System.out.println(p.name + " - " + p.price);
        System.out.println("Total: " + calculateTotalCost());
    }
}
