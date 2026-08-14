import java.util.Scanner;

class Patient {
    String name;
    double fee;

    public Patient(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }

    public double calculateFinalAmount(double fee) {
        double discountRate = (fee >= 2000) ? 0.10 : 0.05;
        return fee - (fee * discountRate);
    }

    public void displayBill() {
        double discountRate = (fee >= 2000) ? 0.10 : 0.05;
        double discount = fee * discountRate;
        double finalAmount = calculateFinalAmount(fee);

        System.out.println("Patient Name: " + name);
        System.out.println("Original Fee: ₹" + (int) fee);
        System.out.println("Discount: ₹" + (int) discount);
        System.out.println("Final Amount: ₹" + (int) finalAmount);
        System.out.println("----------------------------------");
    }
}

public class HospitalBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Patient[] patients = new Patient[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Patient Name and Consultation Fee for Patient " + (i + 1) + ":");
            String name = sc.next();
            double fee = sc.nextDouble();
            patients[i] = new Patient(name, fee);
        }

        System.out.println("\n--- CONSULTATION BILLS ---");
        for (int i = 0; i < 5; i++) {
            patients[i].displayBill();
        }
        sc.close();
    }
}