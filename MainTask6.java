class Employee {
    int id;
    String name;
    String designation;

    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    void displayEmployee() {
        System.out.println("ID: " + id + " | Name: " + name + " | Designation: " + designation);
    }
}

public class MainTask6 {
    public static void main(String[] args) {
        // Creating two employee objects with different information
        Employee emp1 = new Employee(1001, "Piyush", "Software Engineer");
        Employee emp2 = new Employee(1002, "Pranay", "Project Manager");

        // Displaying details of both
        emp1.displayEmployee();
        emp2.displayEmployee();
    }
}