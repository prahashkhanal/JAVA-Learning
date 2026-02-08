import java.util.ArrayList;

class GradeManager {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }

    Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(name))
                return s;
        }
        return null;
    }

    void displayAllStudents() {
        for (Student s : students) {
            s.displayStudentDetails();
        }
    }
}
