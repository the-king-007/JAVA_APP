package Course;

public class Course {
    private final String courseCode;
    private final String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void displayCourse() {
        System.out.println("Course Code: " + courseCode + ", Title: " + courseName);
    }
}