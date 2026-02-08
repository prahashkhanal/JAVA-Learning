public class ShoppingMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 500));

        cart.displayCart();
        cart.removeProduct("Mouse");
        cart.displayCart();
    }
}
