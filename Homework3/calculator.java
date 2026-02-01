import java.util.Scanner;

class Calculator {
    int a, b;
    int choice;

    // Parameterized constructor
    Calculator(int x, int y, int ch) {
        a = x;
        b = y;
        choice = ch;
    }

    void calculate() {
        switch (choice) {
            case 1:
                System.out.println("Sum = " + (a + b));
                break;

            case 2:
                System.out.println("Subtraction = " + (a - b));
                break;

            case 3:
                System.out.println("Multiplication = " + (a * b));
                break;

            case 4:
                if (b != 0)
                    System.out.println("Division = " + (a / b));
                else
                    System.out.println("Division by zero not allowed");
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();

        System.out.println("\n1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        // Object creation using parameterized constructor
        Calculator c = new Calculator(n1, n2, ch);
        c.calculate();

        sc.close();
    }
}
