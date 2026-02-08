class Employee {
    String id, name, role;
    double baseSalary;

    Employee(String id, String name, String role, double baseSalary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        switch (role) {
            case "Manager": return baseSalary * 1.2;
            case "Developer": return baseSalary * 1.1;
            case "Designer": return baseSalary * 1.05;
            case "Intern": return 1000;
            default: return baseSalary;
        }
    }

    void display() {
        System.out.println(name + " " + role + " Salary: " + calculateSalary());
    }
}
