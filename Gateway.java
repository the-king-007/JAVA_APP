import java.util.Scanner;

interface PaymentMethod {
    void makePayment(double amount);
}

class UPI implements PaymentMethod {
    private final String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using UPI (" + upiId + ")");
    }
}

class CreditCard implements PaymentMethod {
    private final String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card (" + cardNumber + ")");
    }
}

class NetBanking implements PaymentMethod {
    private final String bankName;

    public NetBanking(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " via Net Banking (" + bankName + ")");
    }
}

public class Gateway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Payment Method: 1. UPI  2. Credit Card  3. Net Banking");
        int choice = scanner.nextInt();
        scanner.nextLine();

        PaymentMethod payment = null;

        switch (choice) {
            case 1 -> payment = new UPI("user@paytm");
            case 2 -> payment = new CreditCard("XXXX-XXXX-XXXX-1234");
            case 3 -> payment = new NetBanking("HDFC Bank");
            default -> {
                System.out.println("Invalid choice!");
                return;
            }
        }

        payment.makePayment(2500.50);
    }
}