import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/CollegeDB";
    private static final String USER = "root";
    private static final String PASS = "password"; // Update MySQL password

    public static void main(String[] args) {
        String courseCode;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Course Code: ");
            courseCode = scanner.nextLine();
        }

        String query = "SELECT StudentID, StudentName, CourseName, Semester FROM CourseRegistration WHERE CourseCode = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, courseCode);
            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            System.out.println("\n--- Student Details for Course Code: " + courseCode + " ---");
            while (rs.next()) {
                found = true;
                int id = rs.getInt("StudentID");
                String name = rs.getString("StudentName");
                String cName = rs.getString("CourseName");
                int sem = rs.getInt("Semester");

                System.out.printf("Student ID: %d | Name: %-10s | Course: %-20s | Semester: %d\n", id, name, cName, sem);
            }

            if (!found) {
                System.out.println("No students are registered for the entered course code: " + courseCode);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}