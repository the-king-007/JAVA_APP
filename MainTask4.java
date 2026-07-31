class Rectangle {
    double length;
    double breadth;

    // Constructor
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to calculate and display area
    void calculateAndDisplayArea() {
        double area = length * breadth;
        System.out.println("Room Dimensions: " + length + "m x " + breadth + "m");
        System.out.println("Estimated Floor Area: " + area + " sq. meters");
    }
}

public class MainTask4 {
    public static void main(String[] args) {
        Rectangle room = new Rectangle(5.5, 4.0);
        room.calculateAndDisplayArea();
    }
}