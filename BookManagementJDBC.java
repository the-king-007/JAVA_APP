import java.sql.*;
import java.util.Scanner;

public class BookManagementJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/LibraryDB";
    private static final String USER = "root";
    private static final String PASS = "password"; // Update MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            while (true) {
                System.out.println("\n--- Library System ---");
                System.out.println("1. Insert Book");
                System.out.println("2. Search Book by ID");
                System.out.println("3. Display Available Books");
                System.out.println("4. Issue Book (Update Status)");
                System.out.println("5. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Book ID: "); int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Title: "); String title = sc.nextLine();
                        System.out.print("Author: "); String author = sc.nextLine();
                        System.out.print("Price: "); double price = sc.nextDouble();

                        String insQuery = "INSERT INTO Book VALUES (?, ?, ?, ?, true)";
                        try (PreparedStatement pstmt = conn.prepareStatement(insQuery)) {
                            pstmt.setInt(1, id);
                            pstmt.setString(2, title);
                            pstmt.setString(3, author);
                            pstmt.setDouble(4, price);
                            pstmt.executeUpdate();
                            System.out.println("Book inserted successfully.");
                        }
                    }

                    case 2 -> {
                        System.out.print("Enter Book ID to search: "); int sId = sc.nextInt();
                        String searchSql = "SELECT * FROM Book WHERE BookID = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(searchSql)) {
                            pstmt.setInt(1, sId);
                            ResultSet rs = pstmt.executeQuery();
                            if (rs.next()) {
                                System.out.println("ID: " + rs.getInt("BookID") + " | Title: " + rs.getString("Title") +
                                        " | Author: " + rs.getString("Author") + " | Price: ₹" + rs.getDouble("Price") +
                                        " | Available: " + rs.getBoolean("Availability"));
                            } else {
                                System.out.println("Book ID not found.");
                            }
                        }
                    }

                    case 3 -> {
                        String availSql = "SELECT * FROM Book WHERE Availability = true";
                        try (Statement stmt = conn.createStatement();
                                ResultSet rs = stmt.executeQuery(availSql)) {
                            System.out.println("\n--- Available Books ---");
                            while (rs.next()) {
                                System.out.println("ID: " + rs.getInt("BookID") + " | " + rs.getString("Title") + " | Author: " + rs.getString("Author"));
                            }
                        }
                    }

                    case 4 -> {
                        System.out.print("Enter Book ID to issue: "); int issueId = sc.nextInt();
                        String updateSql = "UPDATE Book SET Availability = false WHERE BookID = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                            pstmt.setInt(1, issueId);
                            int rows = pstmt.executeUpdate();
                            if (rows > 0) System.out.println("Book status changed to Unavailable.");
                            else System.out.println("Book ID not found.");
                        }
                    }

                    case 5 -> {
                        System.out.println("Exiting program.");
                        return;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}