package com.cg.onlineShopping.services;

import com.cg.onlineShopping.entities.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductService {
	 private static final String URL =
	            "jdbc:mysql://localhost:3306/online_shopping";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Srishpass@143";

	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

	    // Add Product
	    public void addProduct(Product p) throws SQLException {
	        String sql = "INSERT INTO products VALUES (?, ?, ?, ?)";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, p.getProductId());
	            ps.setString(2, p.getName());
	            ps.setDouble(3, p.getPrice());
	            ps.setInt(4, p.getStockQuantity());

	            ps.executeUpdate();
	            System.out.println("Product added successfully!");
	        }
	    }

	    // View All Products
	    public List<Product> getProducts() throws SQLException {
	        List<Product> products = new ArrayList<>();
	        String sql = "SELECT * FROM products";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                Product p = new Product(
	                    rs.getInt("product_id"),
	                    rs.getString("name"),
	                    rs.getDouble("price"),
	                    rs.getInt("stock_quantity")
	                );
	                products.add(p);
	            }
	        }
	        return products;
	    }

	    // Update Product
	    public boolean updateProduct(Product p) throws SQLException {
	        String sql = "UPDATE products SET name=?, price=?, stock_quantity=? WHERE product_id=?";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, p.getName());
	            ps.setDouble(2, p.getPrice());
	            ps.setInt(3, p.getStockQuantity());
	            ps.setInt(4, p.getProductId());

	            return ps.executeUpdate() > 0;
	        }
	    }

	    // Remove Product
	    public boolean removeProduct(int productId) throws SQLException {
	        String sql = "DELETE FROM products WHERE product_id=?";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, productId);
	            return ps.executeUpdate() > 0;
	        }
	    }

}
