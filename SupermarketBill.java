import java.util.Scanner;

public class SupermarketBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] prices = new double[5];
        double totalBill = 0;

        for (int i = 0; i < 5; i++) {
            prices[i] = scanner.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            totalBill += prices[i];
        }

        System.out.println("Total Bill : " + (int) totalBill);

        if (totalBill > 5000) {
            System.out.println("Discount Applicable");
        } else {
            System.out.println("No Discount");
        }

        scanner.close();
    }
}