import java.util.*;

class Student {
    String name;
    List<Double> grades = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addGrade(double grade) {
        grades.add(grade);
    }

    double calculateAverage() {
        double sum = 0;
        for (double g : grades)
            sum += g;
        return grades.size() == 0 ? 0 : sum / grades.size();
    }

    void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
    }
}

class GradeManager {
    List<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(name))
                return s;
        }
        return null;
    }

    void displayAllStudents() {
        for (Student s : students)
            s.displayStudentDetails();
    }
}

public class Main {
    public static void main(String[] args) {
        GradeManager gm = new GradeManager();

        Student s1 = new Student("Prahash");
        s1.addGrade(85);
        s1.addGrade(90);

        gm.addStudent(s1);
        gm.displayAllStudents();
    }
}
