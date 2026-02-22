// Custom Exceptions
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// BankAccount Class
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InsufficientFundsException, InvalidAmountException {

        if (amount % 100 != 0) {
            throw new InvalidAmountException("Amount must be multiple of 100");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance");
        }

        balance -= amount;
        System.out.println("Withdrawal successful!");
        System.out.println("Remaining balance: " + balance);
    }
}

// Main Class
public class ATMTest {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("12345", 5000);

        try {
            acc.withdraw(600);
            acc.withdraw(6000);  // Insufficient funds
        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}