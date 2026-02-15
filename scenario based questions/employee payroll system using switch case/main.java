import java.util.*;

class Employee {
    String employeeId;
    String name;
    String role;
    double baseSalary;
    double finalSalary;

    Employee(String id, String name, String role, double baseSalary) {
        this.employeeId = id;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
    }

    void calculateSalary() {
        switch (role) {
            case "Manager":
                finalSalary = baseSalary + (0.20 * baseSalary);
                break;
            case "Developer":
                finalSalary = baseSalary + (0.10 * baseSalary);
                break;
            case "Designer":
                finalSalary = baseSalary + (0.05 * baseSalary);
                break;
            case "Intern":
                finalSalary = 1000;
                break;
            default:
                finalSalary = baseSalary;
        }
    }

    void applyDeduction(double amount) {
        finalSalary -= amount;
    }

    void displayEmployeeDetails() {
        System.out.println(employeeId + " - " + name + " - " + role + " - Salary: " + finalSalary);
    }
}

class Payroll {
    List<Employee> employees = new ArrayList<>();

    void addEmployee(Employee e) {
        employees.add(e);
    }

    void calculateAllSalaries() {
        for (Employee e : employees) {
            e.calculateSalary();
            e.displayEmployeeDetails();
        }
    }

    Employee findEmployeeById(String id) {
        for (Employee e : employees)
            if (e.employeeId.equals(id))
                return e;
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();

        Employee e1 = new Employee("E1", "Prahash", "Manager", 50000);
        payroll.addEmployee(e1);

        payroll.calculateAllSalaries();

        e1.applyDeduction(2000);
        e1.displayEmployeeDetails();
    }
}
