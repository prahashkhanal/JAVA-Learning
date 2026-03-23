import java.util.*;

abstract class Plan {
    private String patientName;
    private double baseFee;

    public Plan(String patientName, double baseFee) {
        this.patientName = patientName;
        this.baseFee = baseFee;
    }

    public String getPatientName() {
        return patientName;
    }
    public double getBaseFee() {
        return baseFee;
    }
    public abstract double calculateBill();
}

class SilverPlan extends Plan {

    public SilverPlan(String patientName, double baseFee) {
        super(patientName, baseFee);
    }

    @Override
    public double calculateBill() {
        return getBaseFee() + 15;
    }
}

class GoldPlan extends Plan {
    public GoldPlan(String patientName, double baseFee) {
        super(patientName, baseFee);
    }

    @Override
    public double calculateBill() {
        double surcharge = getBaseFee() * 0.10;
        return getBaseFee() + surcharge - 20;
    }
}

public class caseone {
    public static void printInvoice(Plan p) {
        System.out.println("Patient: " + p.getPatientName());
        System.out.println("Final Bill: " + p.calculateBill());
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Plan p1 = new SilverPlan("John", 100);
        Plan p2 = new GoldPlan("Sophia", 200);
        Plan p3 = new GoldPlan("Max", 50);

        printInvoice(p1);
        printInvoice(p2);
        printInvoice(p3);
    }

}