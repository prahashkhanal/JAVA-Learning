
class Persons {
    String name;

    void Display() {
        System.out.println("Name: " + name);
    }

        public static void main(String[] args){
        Persons p = new Persons();
        p.name = "John";
        p.Display();
    }
}
