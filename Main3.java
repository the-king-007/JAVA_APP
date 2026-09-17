class ExamTask implements Runnable {
    private final String taskDetails;
    private final int interval;

    public ExamTask(String taskDetails, int interval) {
        this.taskDetails = taskDetails;
        this.interval = interval;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] Activity: " + taskDetails);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        Thread timerThread = new Thread(new ExamTask("Displaying remaining exam time", 1000));
        Thread autoSaveThread = new Thread(new ExamTask("Auto-saving student answers", 2000));
        Thread networkThread = new Thread(new ExamTask("Checking network connection", 1500));

        timerThread.setName("Timer-Thread");
        autoSaveThread.setName("AutoSave-Thread");
        networkThread.setName("Network-Thread");

        timerThread.start();
        autoSaveThread.start();
        networkThread.start();
    }
}