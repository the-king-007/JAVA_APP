interface Payment {
    void pay(double amount);
}

// Marker / Tagging Interface
interface OnlineTransaction {}

// Interface extending another interface
interface SecurePayment extends Payment {
    boolean verifyPayment();
}

class CardPayment implements Payment, OnlineTransaction {
    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card ending with " + 
                           cardNumber.substring(cardNumber.length() - 4));
    }
}

class UPIPayment implements SecurePayment, OnlineTransaction {
    private final String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean verifyPayment() {
        System.out.println("2FA OTP verified for UPI ID: " + upiId);
        return true;
    }

    @Override
    public void pay(double amount) {
        if (verifyPayment()) {
            System.out.println("Paid ₹" + amount + " via UPI ID: " + upiId);
        }
    }
}

class Account {
    protected final String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account No: " + accountNumber + ", Balance: ₹" + balance);
    }
}

class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Savings Account -> No: " + accountNumber + 
                           ", Balance: ₹" + balance + ", Interest: " + interestRate + "%");
    }
}

class CurrentAccount extends Account {
    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayDetails() {
        System.out.println("Current Account -> No: " + accountNumber + 
                           ", Balance: ₹" + balance + ", Overdraft Limit: ₹" + overdraftLimit);
    }
}

public class main2 {
    public static void main(String[] args) {
        // --- Part A: Account Polymorphism ---
        System.out.println("--- ACCOUNT DETAILS ---");
        Account acc1 = new SavingsAccount("SA-101", 50000.0, 4.0);
        Account acc2 = new CurrentAccount("CA-202", 120000.0, 20000.0);

        acc1.displayDetails(); // Dynamic method dispatch
        acc2.displayDetails();

        System.out.println("\n--- TRANSACTIONS ---");
        // --- Part B: Payments & Tagging Interface Check ---
        Payment p1 = new UPIPayment("pranay@upi");
        Payment p2 = new CardPayment("1234567890123456");

        processPayment(p1, 1500.0);
        processPayment(p2, 4500.0);
    }

    // Checks if payment method implements the OnlineTransaction tagging interface
    public static void processPayment(Payment payment, double amount) {
        if (payment instanceof OnlineTransaction) {
            System.out.println("[TAG CHECK] Valid Online Transaction.");
            payment.pay(amount);
        } else {
            System.out.println("[TAG CHECK] Invalid Transaction Type.");
        }
    }
}