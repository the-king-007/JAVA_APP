class Employee {
    private final int empId;
    private final String name;
    private final double salary;

    // Constructor to initialize attributes
    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary : " + (int) salary);
    }
}

public class EmployeeDetails {
    public static void employeeDetails(String[] args) {
        // Instantiate and display
        Employee emp = new Employee(101, "Rahul", 45000);
        emp.displayDetails();
    }
}