import java.util.Scanner;

abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private final double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    private final double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Shape: 1. Circle  2. Rectangle  3. Triangle");
        int choice = sc.nextInt();

        Shape shape = null;

        switch (choice) {
            case 1 -> {
                System.out.print("Enter radius: ");
                shape = new Circle(sc.nextDouble());
            }
            case 2 -> {
                System.out.print("Enter length and width: ");
                shape = new Rectangle(sc.nextDouble(), sc.nextDouble());
            }
            case 3 -> {
                System.out.print("Enter base and height: ");
                shape = new Triangle(sc.nextDouble(), sc.nextDouble());
            }
            default -> {
                System.out.println("Invalid selection.");
                return;
            }
        }

        System.out.println("Calculated Area: " + String.format("%.2f", shape.calculateArea()));
    }
}