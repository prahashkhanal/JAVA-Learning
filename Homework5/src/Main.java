// Parent class
class Parent {
    int x = 10;

    Parent() {
        System.out.println("Parent constructor called");
    }
}

// Child class
class Child extends Parent {
    int x = 20;

    Child(int x) {
        // this keyword refers to current class variable
        this.x = x;

        // super keyword refers to parent class variable
        System.out.println("Parent class variable x = " + super.x);
        System.out.println("Child class variable x = " + this.x);
    }

    public static void main(String[] args) {
        Child c = new Child(50);
    }
}
