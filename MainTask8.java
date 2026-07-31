class Temperature {
    double celsius;

    Temperature(double celsius) {
        this.celsius = celsius;
    }

    // Method to convert and display both units
    void displayConversion() {
        // Applying the conversion formula: (Celsius * 9/5) + 32
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;

        System.out.println("--- International Weather Report ---");
        System.out.println("Temperature in Celsius: " + celsius + "°C");
        System.out.println("Temperature in Fahrenheit: " + fahrenheit + "°F");
    }
}

public class MainTask8 {
    public static void main(String[] args) {
        Temperature report = new Temperature(25.0); // 25°C room temperature
        report.displayConversion();
    }
}