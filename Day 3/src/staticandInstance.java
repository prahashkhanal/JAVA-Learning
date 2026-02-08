class Demo {
    int x = 10;          // instance variable
    static int y = 20;   // static variable

    // static method
    static void display() {
        Demo d = new Demo();   // object required for instance variable
        System.out.println("Instance variable x = " + d.x);
        System.out.println("Static variable y = " + y);
    }

    public static void main(String[] args) {
        display();  // calling static method
    }
}
