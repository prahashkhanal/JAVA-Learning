class VariableDemo {
    int x = 10;          // instance variable
    static int y = 20;   // static variable

    // instance method
    void display() {
        System.out.println("Instance variable x = " + x);
        System.out.println("Static variable y = " + y);
    }

    public static void main(String[] args) {
        VariableDemo d = new VariableDemo(); // object creation
        d.display();                         // calling instance method
    }
}
