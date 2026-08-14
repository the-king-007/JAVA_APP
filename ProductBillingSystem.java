import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayBill() {
        double totalPrice = price * quantity;
        double discountRate = (totalPrice >= 5000) ? 0.10 : 0.05;
        double discount = totalPrice * discountRate;
        double finalPrice = totalPrice - discount;

        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Total Price: ₹" + (int) totalPrice);
        System.out.println("Discount: ₹" + (int) discount);
        System.out.println("Final Price: ₹" + (int) finalPrice);
        System.out.println("---------------------------------");
    }
}

public class ProductBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Product " + (i + 1) + ":");
            System.out.println(" (ID, Name, Price, Quantity):");
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            products[i] = new Product(id, name, price, quantity);
        }

        System.out.println("\n--- PRODUCT BILLS ---");
        for (int i = 0; i < 5; i++) {
            products[i].displayBill();
        }
        sc.close();
    }
}