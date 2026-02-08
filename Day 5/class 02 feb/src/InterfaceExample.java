interface Animals {
    void sound();
}

class Dogs implements Animals {
    public void sound() {
        System.out.println("Dog barks. ");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Animals a = new Dogs();
        a.sound();
    }
}