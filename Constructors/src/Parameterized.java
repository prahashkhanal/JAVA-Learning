class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    void Display () {
        System.out.println("Name: " + name + " Age: " + age);
    }
}


public class Parameterized {
    public static void main(String[] args) {
        Student student1 = new Student("Prahash", 20);
        student1.Display();
    }
}
