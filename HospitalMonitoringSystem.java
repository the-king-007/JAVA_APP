class EmergencyAlert extends Thread {
    public EmergencyAlert() {
        setName("EmergencyAlert");
        setPriority(Thread.MAX_PRIORITY); // Highest Priority (10)
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName() + " | Priority: " + getPriority() + " | Action: Handling critical patient alerts!");
    }
}

class VitalMonitor extends Thread {
    public VitalMonitor() {
        setName("VitalMonitor");
        setPriority(Thread.NORM_PRIORITY); // Medium Priority (5)
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName() + " | Priority: " + getPriority() + " | Action: Continuously checking vital signs...");
    }
}

class ReportGenerator extends Thread {
    public ReportGenerator() {
        setName("ReportGenerator");
        setPriority(Thread.MIN_PRIORITY); // Lowest Priority (1)
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName() + " | Priority: " + getPriority() + " | Action: Preparing routine medical reports.");
    }
}

public class HospitalMonitoringSystem {
    public static void main(String[] args) {
        EmergencyAlert t1 = new EmergencyAlert();
        VitalMonitor t2 = new VitalMonitor();
        ReportGenerator t3 = new ReportGenerator();

        t1.start();
        t2.start();
        t3.start();
    }
}