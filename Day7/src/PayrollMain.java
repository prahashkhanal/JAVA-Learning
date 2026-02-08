public class PayrollMain {
    public static void main(String[] args) {
        Employee e1 = new Employee("1", "Neha", "Manager", 50000);
        Employee e2 = new Employee("2", "Ravi", "Intern", 0);

        e1.display();
        e2.display();
    }
}
