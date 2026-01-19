class Person {
    String name;
    int age;


    Person() {
        name = "Default name";
        age = 18;

    }

    void display() {
        System.out.println("Name: " + name + " Age: " + age);

    }
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.display();
    }
}