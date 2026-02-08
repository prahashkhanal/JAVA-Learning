import java.util.ArrayList;

class Student {
    String name;
    ArrayList<Double> grades = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addGrade(double grade) {
        grades.add(grade);
    }

    double calculateAverage() {
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    void displayStudentDetails() {
        System.out.println(name + " " + grades +
                " Avg: " + calculateAverage());
    }
}
