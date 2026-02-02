abstract class Animal {
    abstract void sound();

    void eat() {
        System.out.println("This animal eats food. ");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks. ");
    }
}

public class AbstractMethodExample {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
        animal.eat();
    }
}