class parent {
    int a = 10;

    parent() {
        System.out.println("Parent class constructor");
    }

    void show() {
        System.out.println("Value of a in Parent class: " + a);
    }
}

class child extends parent {
    int a = 20;

    child() {
        super();
        System.out.println("Child class constructor");
    }

    void display() {
        System.out.println("Value of a using this keyword: " + this.a);
        System.out.println("Value of a using super keyword: " + super.a);

        this.show();
        super.show();
    }
}

public class first {
    public static void main(String[] args) {
        child obj = new child();
        obj.display();
    }
}