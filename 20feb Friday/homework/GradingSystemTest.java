// Custom Exception
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

// Student Class
class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) throws InvalidMarksException {
        this.name = name;
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    public void assignGrade() {
        if (marks >= 90)
            System.out.println(name + " Grade: A");
        else if (marks >= 75)
            System.out.println(name + " Grade: B");
        else if (marks >= 50)
            System.out.println(name + " Grade: C");
        else
            System.out.println(name + " Grade: Fail");
    }
}

// Main Class
public class GradingSystemTest {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("Rahul", 85);
            s1.assignGrade();

            Student s2 = new Student("Aman", 120); // Exception
            s2.assignGrade();
        } catch (InvalidMarksException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}