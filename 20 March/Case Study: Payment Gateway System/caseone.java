import java.util.*;

abstract class Payment {
    private String transactionId;
    private double amount;

    public Payment(String transactionId, double amount){
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public abstract double processPayment();
}

class CreditCardPayment extends Payment {
    public CreditCardPayment(String transactionID, double amount) {
        super(transactionID, amount);
    }

    @Override
    public double processPayment() {
        double fee = getAmount() * 0.02;
        return getAmount() + fee;
    }
}

class UPIPayment extends Payment {
    public UPIPayment(String transactionId, double amount) {
        super(transactionId, amount);
    }

    @Override
    public double processPayment() {
        return getAmount();
    }
}

class PaymentProcessor {
    public void process(Payment p) {
        double result = p.processPayment();
        System.out.printf("Processed Payment: %.2f\n", result);
    }
}

public class caseone {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment("TXN121", 1000);
        Payment p2 = new UPIPayment("TXN122", 1000);

        PaymentProcessor processor = new PaymentProcessor();

        processor.process(p1);
        processor.process(p2);

        Payment[] payments = {p1,p2};

        double total = 0;

        for (Payment p : payments) {
            total += p.processPayment();
        }
        System.out.printf("Total: %.2f \n", total);
    }
}