// Class 1
class A {
    int x;

    void setValue(int a) {   // parameterized method
        x = a;
    }
}

// Class 2
class B {
    int y;

    void setValue(int b) {   // parameterized method
        y = b;
    }
}

// Class 3 (Main class)
class C {
    int z;

    void setValue(int c) {   // parameterized method
        z = c;
    }

    public static void main(String[] args) {

        // Object creation
        A obj1 = new A();
        B obj2 = new B();
        C obj3 = new C();

        // ---- OPTION 1: Command line input ----
        if (args.length == 3) {
            obj1.setValue(Integer.parseInt(args[0]));
            obj2.setValue(Integer.parseInt(args[1]));
            obj3.setValue(Integer.parseInt(args[2]));
        }
        // ---- OPTION 2: Predefined values ----
        else {
            obj1.setValue(10);
            obj2.setValue(20);
            obj3.setValue(30);
        }

        // Accessing variables using object calls
        System.out.println("Value from class A: " + obj1.x);
        System.out.println("Value from class B: " + obj2.y);
        System.out.println("Value from class C: " + obj3.z);
    }
}
