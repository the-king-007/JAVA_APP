class RegisteredStudent {
    String name;
    int rollNumber;

    // Constructor
    RegisteredStudent(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // Dedicated display method
    void display() {
        System.out.println("Registration Details -> Name: " + name + ", Roll Number: " + rollNumber);
    }
}

public class MainTask3 {
    public static void main(String[] args) {
        RegisteredStudent student = new RegisteredStudent("Pranay", 534);
        // Displaying details whenever required
        student.display();
    }
}