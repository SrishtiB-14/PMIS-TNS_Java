package com.cg.onlineShopping.services;

import com.cg.onlineShopping.entities.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	 private static final String URL =
	            "jdbc:mysql://localhost:3306/online_shopping";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Srishpass@143";

	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

	    public void createCustomer(Customer c) throws SQLException {

	        String userSql =
	                "INSERT INTO users (user_id, username, email, role) "
	                + "VALUES (?, ?, ?, 'CUSTOMER')";

	        String customerSql =
	                "INSERT INTO customers (user_id, address) VALUES (?, ?)";

	        try (Connection con = getConnection()) {
	            con.setAutoCommit(false);

	            try {
	                try (PreparedStatement ps = con.prepareStatement(userSql)) {
	                    ps.setInt(1, c.getUserId());
	                    ps.setString(2, c.getUsername());
	                    ps.setString(3, c.getEmail());
	                    ps.executeUpdate();
	                }

	                try (PreparedStatement ps = con.prepareStatement(customerSql)) {
	                    ps.setInt(1, c.getUserId());
	                    ps.setString(2, c.getAddress());
	                    ps.executeUpdate();
	                }

	                try (PreparedStatement ps = con.prepareStatement(
	                        "INSERT INTO carts (customer_id) VALUES (?)")) {
	                    ps.setInt(1, c.getUserId());
	                    ps.executeUpdate();
	                }

	                con.commit();
	                System.out.println("Customer created successfully!");

	            } catch (SQLException e) {
	                con.rollback();
	                throw e;
	            }
	        }
	    }

	    public List<Customer> getCustomers() throws SQLException {

	        List<Customer> customers = new ArrayList<>();

	        String sql = "SELECT u.user_id, u.username, u.email, c.address "
	                + "FROM users u JOIN customers c ON u.user_id = c.user_id";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                customers.add(new Customer(
	                        rs.getInt("user_id"),
	                        rs.getString("username"),
	                        rs.getString("email"),
	                        rs.getString("address")
	                ));
	            }
	        }

	        return customers;
	    }

	    public void addToCart(int customerId, int productId, int quantity)
	            throws SQLException {

	        if (quantity <= 0) {
	            throw new IllegalArgumentException("Quantity must be greater than zero.");
	        }

	        String sql = "INSERT INTO cart_items (cart_id, product_id, quantity) "
	                + "VALUES ((SELECT cart_id FROM carts WHERE customer_id = ?), ?, ?) "
	                + "ON DUPLICATE KEY UPDATE quantity = quantity + VALUES(quantity)";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, customerId);
	            ps.setInt(2, productId);
	            ps.setInt(3, quantity);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Product added to cart successfully!");
	            }
	        }
	    }

	    public void viewCart(int customerId) throws SQLException {

	        String sql = "SELECT p.product_id, p.name, p.price, ci.quantity, "
	                + "(p.price * ci.quantity) AS total "
	                + "FROM carts c "
	                + "JOIN cart_items ci ON c.cart_id = ci.cart_id "
	                + "JOIN products p ON ci.product_id = p.product_id "
	                + "WHERE c.customer_id = ?";

	        double grandTotal = 0;

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, customerId);

	            try (ResultSet rs = ps.executeQuery()) {
	                System.out.println("\n--- Shopping Cart ---");

	                while (rs.next()) {
	                    System.out.println(
	                            "Product ID: " + rs.getInt("product_id")
	                            + ", Name: " + rs.getString("name")
	                            + ", Price: " + rs.getDouble("price")
	                            + ", Quantity: " + rs.getInt("quantity")
	                            + ", Total: " + rs.getDouble("total")
	                    );

	                    grandTotal += rs.getDouble("total");
	                }

	                System.out.println("Grand Total: " + grandTotal);
	            }
	        }
	    }

	    public void removeFromCart(int customerId, int productId)
	            throws SQLException {

	        String sql = "DELETE ci FROM cart_items ci "
	                + "JOIN carts c ON ci.cart_id = c.cart_id "
	                + "WHERE c.customer_id = ? AND ci.product_id = ?";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, customerId);
	            ps.setInt(2, productId);

	            if (ps.executeUpdate() > 0) {
	                System.out.println("Product removed from cart!");
	            } else {
	                System.out.println("Product not found in cart.");
	            }
	        }
	    }
	

}
