public class SalaryCalculator {
    public static void main(String[] args) {
        double basicSalary = 45000.00;
        double allowance = 12500.50;

        double totalSalary = basicSalary + allowance;

        System.out.println("--- Employee Salary Details ---");
        System.out.printf("Basic Salary  : %.2f%n", basicSalary);
        System.out.printf("Allowance     : %.2f%n", allowance);
        System.out.println("---------------------------------");
        System.out.printf("Total Monthly Salary: %.2f%n", totalSalary);
        System.out.println("---------------------------------");
    }
}