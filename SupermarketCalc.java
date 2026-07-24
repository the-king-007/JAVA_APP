public class SupermarketCalc {
    public static void main(String[] args) {
        double price1 = 250.50;
        double price2 = 120.25;

        double total = price1 + price2;
        double difference = price1 - price2;
        double product = price1 * price2;
        double quotient = price1 / price2;
        double remainder = price1 % price2;

        System.out.println("--- Supermarket Billing Calculations ---");
        System.out.printf("Product 1 Price : %.2f%n", price1);
        System.out.printf("Product 2 Price : %.2f%n", price2);
        System.out.println("---------------------------------------");
        System.out.printf("Total (Sum)     : %.2f%n", total);
        System.out.printf("Difference      : %.2f%n", difference);
        System.out.printf("Product         : %.2f%n", product);
        System.out.printf("Quotient        : %.4f%n", quotient);
        System.out.printf("Remainder (Mod) : %.2f%n", remainder);
    }
}