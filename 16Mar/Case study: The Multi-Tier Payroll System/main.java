import java.util.*;

class Employee {
    String name;
    double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        return baseSalary + (0.05 * baseSalary);
    }
}

class Manager extends Employee {

    Manager(String name, double baseSalary) {
        super(name,baseSalary);
    }

    @Override
    double calculateSalary() {

        return super.calculateSalary() + 2000;
    }
}

class Executive extends Manager {

    Executive(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {

        return super.calculateSalary() + (0.10 * baseSalary);
    }
}

public class main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 10000);
        Employee emp2 = new Manager("Bob", 10000);
        Employee emp3 = new Executive("Charlie", 10000);

        System.out.println(emp1.calculateSalary());
        System.out.println(emp2.calculateSalary());
        System.out.println(emp3.calculateSalary());

        System.out.printf("Employee Salary: %.2f \n", emp1.calculateSalary());
        System.out.printf("Manager Salary: %.2f \n", emp2.calculateSalary());
        System.out.printf("Executive Salary: %.2f \n", emp3.calculateSalary());
    }
}