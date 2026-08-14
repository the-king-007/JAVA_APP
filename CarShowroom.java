class Car {
    private final String model;
    private final double price;

    // 1. Constructor with no parameters
    public Car() {
        this.model = "Unknown";
        this.price = 0.0;
    }

    // 2. Constructor with model only
    public Car(String model) {
        this.model = model;
        this.price = 0.0;
    }

    // 3. Constructor with model and price
    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Model: " + model + " | Price: ₹" + price);
    }
}

public class CarShowroom {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Sedan");
        Car car3 = new Car("SUV", 1500000);

        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();
    }
}