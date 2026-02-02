abstract class Shapes {
    abstract void draw();

    void message() {
        System.out.println("This is a shape. ");
    }
}

class Circles extends Shapes {
    void draw() {
        System.out.println("Drawing a circle.");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Shapes s = new Circles();
        s.draw();
        s.message();
    }
}