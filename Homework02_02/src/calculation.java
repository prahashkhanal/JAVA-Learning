// abstract class
abstract class Calculation {
    abstract int add(int a, int b);
    abstract int subtract(int a, int b);
    abstract int multiply(int a, int b);
    abstract double divide(int a, int b);
}

// implementation class
class SimpleCalculation extends Calculation {

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    double divide(int a, int b) {
        return (double) a / b;
    }
}

// main class (ONLY public class)
public class calculation {

    public static void main(String[] args) {
        Calculation calc = new SimpleCalculation();

        System.out.println(calc.add(10, 5));
        System.out.println(calc.subtract(10, 5));
        System.out.println(calc.multiply(10, 5));
        System.out.println(calc.divide(10, 5));
    }
}
