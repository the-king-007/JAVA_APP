interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card ending with " + 
                           cardNumber.substring(cardNumber.length() - 4));
    }
}

class UPIPayment implements Payment {
    private final String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI ID: " + upiId);
    }
}

class NetBankingPayment implements Payment {
    private final String bankName;

    public NetBankingPayment(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Net Banking (" + bankName + ")");
    }
}

public class PaymentMain {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment("1234567890123456");
        Payment p2 = new UPIPayment("user@upi");
        Payment p3 = new NetBankingPayment("HDFC Bank");

        p1.pay(1500.50);
        p2.pay(450.00);
        p3.pay(12000.00);
    }
}