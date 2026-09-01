import Course.Course;
import Student.Student;

public class Main {
    public static void main(String[] args) {
        Student s = new Student(101, "Pranay Singh");
        Course c = new Course("CS201", "Object Oriented Programming in Java");

        s.displayStudent();
        c.displayCourse();
    }
}