class StudentRecord {
    String name;
    int age;

    StudentRecord(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Student Name: " + name + " | Age: " + age);
    }
}

public class MainTask5 {
    public static void main(String[] args) {
        // Creating two student objects with different names and ages
        StudentRecord student1 = new StudentRecord("Pranay", 19);
        StudentRecord student2 = new StudentRecord("Soju", 21);

        // Displaying details individually
        student1.displayDetails();
        student2.displayDetails();
    }
}