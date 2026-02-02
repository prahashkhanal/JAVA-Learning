class StudentStatic {
    int rollNo;
    String name;
    static String college = "ABC College";

    StudentStatic(int r, String n) {
        rollNo = r;
        name = n;
    }

    void display() {
        System.out.println("Name    : " + name);
        System.out.println("Roll No : " + rollNo);
        System.out.println("College : " + college);
    }

    public static void main(String[] args) {
        StudentStatic s1 = new StudentStatic(1, "Prahash");
        StudentStatic s2 = new StudentStatic(2, "Rahul");

        s1.display();
        System.out.println();
        s2.display();
    }
}
