class OrderProcessingTask implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        System.out.println("Thread Name: " + current.getName() + 
                           " | Priority: " + current.getPriority() + 
                           " | Activity: Processing customer orders and payment verification.");
    }
}

class DeliveryTrackingTask implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        System.out.println("Thread Name: " + current.getName() + 
                           " | Priority: " + current.getPriority() + 
                           " | Activity: Tracking live GPS location of the delivery executive.");
    }
}

class NotificationTask implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        System.out.println("Thread Name: " + current.getName() + 
                           " | Priority: " + current.getPriority() + 
                           " | Activity: Sending push notifications and SMS order updates.");
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        Thread t1 = new Thread(new OrderProcessingTask(), "OrderProcessing");
        Thread t2 = new Thread(new DeliveryTrackingTask(), "DeliveryTracking");
        Thread t3 = new Thread(new NotificationTask(), "Notification");

        // Assign different priorities based on task importance
        t1.setPriority(Thread.MAX_PRIORITY);  // Priority 10
        t2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        t3.setPriority(Thread.MIN_PRIORITY);  // Priority 1

        t1.start();
        t2.start();
        t3.start();
    }
}