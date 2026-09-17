class BankActivity implements Runnable {
    private final String activityName;
    private final int delay;

    public BankActivity(String activityName, int delay) {
        this.activityName = activityName;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int executionCount = 1; executionCount <= 3; executionCount++) {
            System.out.println("Thread Name: " + Thread.currentThread().getName() +
                               " | Activity: " + activityName +
                               " | Execution Count: " + executionCount);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        Thread transactionThread = new Thread(new BankActivity("Transaction Processing", 800));
        Thread balanceThread = new Thread(new BankActivity("Balance Updating", 1200));
        Thread smsThread = new Thread(new BankActivity("SMS Notification", 500));

        transactionThread.setName("Txn-Processor");
        balanceThread.setName("Balance-Updater");
        smsThread.setName("SMS-Notifier");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();
    }
}