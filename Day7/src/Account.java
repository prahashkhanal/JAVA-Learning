class Account {
    String accountNumber;
    String holder;
    double balance;

    Account(String acc, String holder, double balance) {
        this.accountNumber = acc;
        this.holder = holder;
        this.balance = balance;
    }

    void deposit(double amt) {
        balance += amt;
    }

    void withdraw(double amt) throws InsufficientFundsException {
        if (amt > balance)
            throw new InsufficientFundsException("Insufficient Balance");
        balance -= amt;
    }

    void display() {
        System.out.println(accountNumber + " " + holder + " " + balance);
    }
}
