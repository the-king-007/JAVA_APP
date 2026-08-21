class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance > 0 ? balance : 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: $" + balance);
        System.out.println("---------------------------");
    }
}

public class Account {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC1001", "Pranay Singh", 5000.00);
        account.displayAccountDetails();
        account.deposit(1500.00);
        account.withdraw(2000.00);
        account.displayAccountDetails();
    }
}