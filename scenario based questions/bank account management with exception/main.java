import java.util.*;

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {
    String accountNumber;
    String accountHolderName;
    double balance;

    Account(String accNo, String name, double balance) {
        this.accountNumber = accNo;
        this.accountHolderName = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient Funds!");
        balance -= amount;
    }

    void transfer(Account target, double amount) throws InsufficientFundsException {
        withdraw(amount);
        target.deposit(amount);
    }

    void displayAccountDetails() {
        System.out.println(accountNumber + " - " + accountHolderName + " - Balance: " + balance);
    }
}

class Bank {
    List<Account> accounts = new ArrayList<>();

    void createAccount(String accNo, String name, double balance) {
        accounts.add(new Account(accNo, name, balance));
    }

    Account getAccount(String accNo) {
        for (Account a : accounts)
            if (a.accountNumber.equals(accNo))
                return a;
        return null;
    }

    void displayAllAccounts() {
        for (Account a : accounts)
            a.displayAccountDetails();
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount("101", "Prahash", 10000);
        bank.createAccount("102", "Alex", 5000);

        Account a1 = bank.getAccount("101");
        Account a2 = bank.getAccount("102");

        try {
            a1.transfer(a2, 2000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        bank.displayAllAccounts();
    }
}
