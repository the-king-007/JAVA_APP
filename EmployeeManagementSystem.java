import java.util.Scanner;

class Employee {
    int id;
    String name;
    double monthlySalary;

    public Employee(int id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public double getAnnualSalary() {
        return monthlySalary * 12;
    }

    public boolean isEligibleForBonus() {
        return monthlySalary >= 30000;
    }

    public double getBonus() {
        return isEligibleForBonus() ? (getAnnualSalary() * 0.10) : 0.0;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + " | Name: " + name);
        System.out.println("Monthly Salary: ₹" + (int) monthlySalary);
        System.out.println("Annual Salary: ₹" + (int) getAnnualSalary());
        System.out.println("Bonus Eligibility: " + (isEligibleForBonus() ? "Eligible" : "Not Eligible"));
        System.out.println("Bonus Amount: ₹" + (int) getBonus());
        System.out.println("--------------------------------------------------");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter ID, Name, Monthly Salary for Employee " + (i + 1) + ":");
            System.out.println("Enter Monthly Salary for Employee " + (i + 1) + ":");
            System.out.println("Enter Name: ");
            int id = sc.nextInt();
            String name = sc.next();
            double salary = sc.nextDouble();
            employees[i] = new Employee(id, name, salary);
        }

        System.out.println("\n--- EMPLOYEE DETAILS ---");
        for (int i = 0; i < 5; i++) {
            employees[i].displayDetails();
        }
        sc.close();
    }
}