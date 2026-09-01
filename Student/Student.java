package Student;

public class Student {
    private final int studentId;
    private final String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId + ", Name: " + name);
    }
}