class Parent {
    void showParent() {
        System.out.println("This is Parent class");
    }
}

class Child extends Parent {
    void showChild() {
        System.out.println("This is Child class");
    }
}

class Inheritance1 {
    public static void main(String[] args) {
        Child c = new Child();
        c.showParent();  // inherited method
        c.showChild();
    }
}
