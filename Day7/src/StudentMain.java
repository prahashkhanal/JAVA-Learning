public class StudentMain {
    public static void main(String[] args) {
        GradeManager gm = new GradeManager();

        Student s1 = new Student("Rahul");
        s1.addGrade(85);
        s1.addGrade(90);

        gm.addStudent(s1);
        gm.displayAllStudents();
    }
}
