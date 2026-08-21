abstract class Product {
    protected String productId;
    protected String name;
    protected double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double getFinalPrice() {
        return price - calculateDiscount();
    }

    public void displayProductInfo() {
        System.out.println("Product: " + name + " | Base Price: $" + price + " | Final Price: $" + getFinalPrice());
    }
}

class Electronics extends Product {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount
    }
}

class Clothing extends Product {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20; // 20% discount
    }
}

class Books extends Product {
    public Books(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05; // 5% discount
    }
}

public class Products {
    public static void main(String[] args) {
        Product laptop = new Electronics("E101", "Laptop", 1000);
        Product shirt = new Clothing("C201", "Jacket", 200);
        Product novel = new Books("B301", "Novel", 50);

        laptop.displayProductInfo();
        shirt.displayProductInfo();
        novel.displayProductInfo();
    }
}