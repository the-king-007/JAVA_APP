public class StudentInfo {
    public static void main(String[] args) {

        String studentName = "PRANAV KUMAR SINGH";
        String regNumber = "RA2511026010534";
        String department = "Computer Science and Engineering";
        int yearOfStudy = 3;
        String collegeName = "SRM Institute of Technology";

        System.out.println("==============================================");
        System.out.println("          STUDENT INFORMATION SYSTEM          ");
        System.out.println("==============================================");
        System.out.printf("%-18s: %s%n", "Student Name", studentName);
        System.out.printf("%-18s: %s%n", "Register Number", regNumber);
        System.out.printf("%-18s: %s%n", "Department", department);
        System.out.printf("%-18s: Year %d%n", "Year of Study", yearOfStudy);
        System.out.printf("%-18s: %s%n", "College Name", collegeName);
        System.out.println("==============================================");
    }
}