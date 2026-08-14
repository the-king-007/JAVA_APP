class AreaCalculator {

    // Overloaded method: Area of Square
    public double calculateArea(double side) {
        return side * side;
    }

    // Overloaded method: Area of Rectangle
    public double calculateArea(double length, double breadth) {
        return length * breadth;
    }

    // Overloaded method: Area of Circle
    public double calculateArea(double radius, boolean isCircle) {
        return Math.PI * radius * radius;
    }
}

public class GeometryApp {
    public static void main(String[] args) {
        AreaCalculator calc = new AreaCalculator();

        System.out.println("Area of Square (side 4): " + calc.calculateArea(4.0));
        System.out.println("Area of Rectangle (5x6): " + calc.calculateArea(5.0, 6.0));
        System.out.println("Area of Circle (radius 3): " + calc.calculateArea(3.0, true));
    }
}