class Employee {
    protected String name;
    protected String empId;
    protected double basicSalary;

    public Employee(String name, String empId, double basicSalary) {
        this.name = name;
        this.empId = empId;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public void displayDetails() {
        System.out.println("ID: " + empId + " | Name: " + name + " | Total Salary: $" + calculateSalary());
    }
}

class Professor extends Employee {
    private final double researchAllowance;

    public Professor(String name, String empId, double basicSalary, double researchAllowance) {
        super(name, empId, basicSalary);
        this.researchAllowance = researchAllowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + researchAllowance;
    }
}

class LabAssistant extends Employee {
    private final double labIncentive;

    public LabAssistant(String name, String empId, double basicSalary, double labIncentive) {
        super(name, empId, basicSalary);
        this.labIncentive = labIncentive;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + labIncentive;
    }
}

class AdministrativeStaff extends Employee {
    private final double overtimeBonus;

    public AdministrativeStaff(String name, String empId, double basicSalary, double overtimeBonus) {
        super(name, empId, basicSalary);
        this.overtimeBonus = overtimeBonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + overtimeBonus;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee prof = new Professor("Dr. Sharma", "P101", 80000, 15000);
        Employee lab = new LabAssistant("Ramesh", "L201", 30000, 3000);
        Employee admin = new AdministrativeStaff("Suresh", "A301", 40000, 5000);

        prof.displayDetails();
        lab.displayDetails();
        admin.displayDetails();
    }
}