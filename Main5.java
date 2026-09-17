class TrafficJunctionThread extends Thread {
    private final String status;
    private final int sleepInterval;

    public TrafficJunctionThread(String status, int sleepInterval) {
        this.status = status;
        this.sleepInterval = sleepInterval;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread Name: " + getName() + " | Traffic Status: " + status + " | Report #" + i);
            try {
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
        }
    }
}

public class Main5 {
    public static void main(String[] args) {
        TrafficJunctionThread j1 = new TrafficJunctionThread("HEAVY TRAFFIC", 1000);
        TrafficJunctionThread j2 = new TrafficJunctionThread("CLEAR", 1800);
        TrafficJunctionThread j3 = new TrafficJunctionThread("MODERATE TRAFFIC", 1400);

        j1.setName("Junction-A");
        j2.setName("Junction-B");
        j3.setName("Junction-C");

        j1.start();
        j2.start();
        j3.start();
    }
}