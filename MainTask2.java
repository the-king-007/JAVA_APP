final class Book {
    String title;
    String author;
    double price;

    // Constructor to initialize and automatically display details upon creation
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBookDetails() {
        System.out.println("--- New Book Added ---");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println();
    }
}

public class MainTask2 {
    public static void main(String[] args) {
        Book newBook = new Book("Effective Java", "Joshua Bloch", 45.99);
        newBook.displayBookDetails();
    }
}