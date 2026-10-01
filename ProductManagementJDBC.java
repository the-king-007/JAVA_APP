import java.sql.*;

public class ProductManagementJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/StoreDB";
    private static final String USER = "root";
    private static final String PASS = "password"; // Update MySQL password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            
            // 1. Insert a new product
            String insertSql = "INSERT INTO Product VALUES (?, ?, ?, ?)";
            try (PreparedStatement p1 = conn.prepareStatement(insertSql)) {
                p1.setInt(1, 101);
                p1.setString(2, "Wireless Mouse");
                p1.setDouble(3, 450.00);
                p1.setInt(4, 15);
                p1.executeUpdate();
                System.out.println("1. Product inserted successfully.");
            }

            // 2. Retrieve a product using Product ID
            String searchSql = "SELECT * FROM Product WHERE ProductID = ?";
            try (PreparedStatement p2 = conn.prepareStatement(searchSql)) {
                p2.setInt(1, 101);
                ResultSet rs = p2.executeQuery();
                if (rs.next()) {
                    System.out.println("2. Found Product: " + rs.getString("ProductName") + " | Price: ₹" + rs.getDouble("Price") + " | Qty: " + rs.getInt("Quantity"));
                }
            }

            // 3. Update product quantity
            String updateSql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
            try (PreparedStatement p3 = conn.prepareStatement(updateSql)) {
                p3.setInt(1, 4); // Reduce quantity below 10
                p3.setInt(2, 101);
                p3.executeUpdate();
                System.out.println("3. Product quantity updated.");
            }

            // 4. Display all products whose quantity is below 10
            String lowStockSql = "SELECT * FROM Product WHERE Quantity < 10";
            try (PreparedStatement p4 = conn.prepareStatement(lowStockSql);
                 ResultSet rs = p4.executeQuery()) {
                System.out.println("\n4. --- Products with Quantity < 10 ---");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ProductID") + " | Name: " + rs.getString("ProductName") +
                            " | Price: ₹" + rs.getDouble("Price") + " | Qty: " + rs.getInt("Quantity"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}