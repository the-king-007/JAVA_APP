class Student {
    String name;
    int rollNumber;
    String department;

    // Method to display details
    void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Department: " + department);
        System.out.println();
    }
}

public class MainTask {
    public static void main(String[] args) {
        // Creating an object
        Student student = new Student();
        
        // Storing details
        student.name = "Pranay Kumar Singh";
        student.rollNumber = 534;
        student.department = "Computer Science";

        // Displaying details
        student.displayInfo();
    }
}