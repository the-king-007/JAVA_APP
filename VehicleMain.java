class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected double speed;

    public Vehicle(String vehicleNumber, String brand, double speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber + ", Brand: " + brand + ", Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    private final int numberOfDoors;

    public Car(String vehicleNumber, String brand, double speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car -> Vehicle No: " + vehicleNumber + ", Brand: " + brand + 
                           ", Speed: " + speed + " km/h, Doors: " + numberOfDoors);
    }
}

class Bike extends Vehicle {
    private final boolean hasGear;

    public Bike(String vehicleNumber, String brand, double speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike -> Vehicle No: " + vehicleNumber + ", Brand: " + brand + 
                           ", Speed: " + speed + " km/h, Has Gear: " + hasGear);
    }
}

public class VehicleMain {
    public static void main(String[] args) {
        // Runtime Polymorphism using Vehicle reference
        Vehicle v1 = new Car("KA-01-AB-1234", "Toyota", 140.0, 4);
        Vehicle v2 = new Bike("KA-05-XY-9876", "Yamaha", 95.5, true);

        v1.displayDetails();
        v2.displayDetails();
    }
}