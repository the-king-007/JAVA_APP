class Student {
    private final int id;
    private final String name;
    private final String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Department   : " + department);
    }
}

class Course {
    private final String courseCode;
    private final String courseName;
    private final int credits;

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void displayCourseInfo() {
        System.out.println("Course Code : " + courseCode);
        System.out.println("Course Name : " + courseName);
        System.out.println("Credits     : " + credits);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice Smith", "Computer Science");
        Course course = new Course("CS201", "Data Structures", 4);

        System.out.println("--- Student Details ---");
        student.displayStudentInfo();

        System.out.println("\n--- Course Details ---");
        course.displayCourseInfo();
    }
}