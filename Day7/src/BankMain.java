public class BankMain {
    public static void main(String[] args) {
        Account a1 = new Account("101", "Amit", 5000);

        try {
            a1.withdraw(6000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        a1.display();
    }
}

