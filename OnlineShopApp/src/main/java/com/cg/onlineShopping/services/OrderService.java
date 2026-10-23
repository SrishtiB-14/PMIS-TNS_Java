package com.cg.onlineShopping.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/online_shopping";
    private static final String USER = "root";
    private static final String PASSWORD = "root8";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Place an order using the customer's cart
    public void placeOrder(int customerId) throws SQLException {

        String cartSql =
                "SELECT ci.product_id, ci.quantity, p.price, p.stock_quantity "
                + "FROM carts c "
                + "JOIN cart_items ci ON c.cart_id = ci.cart_id "
                + "JOIN products p ON ci.product_id = p.product_id "
                + "WHERE c.customer_id = ? FOR UPDATE";

        try (Connection con = getConnection()) {
            con.setAutoCommit(false);

            try {
                List<int[]> items = new ArrayList<>();
                List<Double> prices = new ArrayList<>();

                try (PreparedStatement ps =
                        con.prepareStatement(cartSql)) {

                    ps.setInt(1, customerId);

                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            int productId = rs.getInt("product_id");
                            int quantity = rs.getInt("quantity");
                            int stock = rs.getInt("stock_quantity");
                            double price = rs.getDouble("price");

                            if (quantity <= 0 || quantity > stock) {
                                throw new SQLException(
                                        "Insufficient stock for product ID: "
                                        + productId);
                            }

                            items.add(new int[]{productId, quantity});
                            prices.add(price);
                        }
                    }
                }

                if (items.isEmpty()) {
                    throw new SQLException("Your cart is empty!");
                }

                int orderId;

                try (PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO orders (customer_id, status, order_date) "
                        + "VALUES (?, 'Pending', NOW())",
                        Statement.RETURN_GENERATED_KEYS)) {

                    ps.setInt(1, customerId);
                    ps.executeUpdate();

                    try (ResultSet keys = ps.getGeneratedKeys()) {
                        if (!keys.next()) {
                            throw new SQLException("Could not create order.");
                        }
                        orderId = keys.getInt(1);
                    }
                }

                String itemSql =
                        "INSERT INTO order_items "
                        + "(order_id, product_id, quantity, price_at_order) "
                        + "VALUES (?, ?, ?, ?)";

                String stockSql =
                        "UPDATE products SET stock_quantity = "
                        + "stock_quantity - ? "
                        + "WHERE product_id = ? AND stock_quantity >= ?";

                try (PreparedStatement itemPs =
                             con.prepareStatement(itemSql);
                     PreparedStatement stockPs =
                             con.prepareStatement(stockSql)) {

                    for (int i = 0; i < items.size(); i++) {
                        int productId = items.get(i)[0];
                        int quantity = items.get(i)[1];

                        itemPs.setInt(1, orderId);
                        itemPs.setInt(2, productId);
                        itemPs.setInt(3, quantity);
                        itemPs.setDouble(4, prices.get(i));
                        itemPs.executeUpdate();

                        stockPs.setInt(1, quantity);
                        stockPs.setInt(2, productId);
                        stockPs.setInt(3, quantity);

                        if (stockPs.executeUpdate() != 1) {
                            throw new SQLException(
                                    "Stock update failed for product ID: "
                                    + productId);
                        }
                    }
                }

                try (PreparedStatement ps = con.prepareStatement(
                        "DELETE ci FROM cart_items ci "
                        + "JOIN carts c ON ci.cart_id = c.cart_id "
                        + "WHERE c.customer_id = ?")) {
                    ps.setInt(1, customerId);
                    ps.executeUpdate();
                }

                con.commit();
                System.out.println(
                        "Order placed successfully! Order ID: " + orderId);

            } catch (SQLException | RuntimeException e) {
                con.rollback();
                throw e;
            }
        }
    }

    // View orders belonging to one customer
    public void viewCustomerOrders(int customerId) throws SQLException {

        String sql =
                "SELECT o.order_id, o.status, o.order_date, "
                + "oi.product_id, p.name, oi.quantity, oi.price_at_order "
                + "FROM orders o "
                + "JOIN order_items oi ON o.order_id = oi.order_id "
                + "JOIN products p ON oi.product_id = p.product_id "
                + "WHERE o.customer_id = ? ORDER BY o.order_id DESC";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\n--- Customer Orders ---");

                boolean found = false;

                while (rs.next()) {
                    found = true;
                    System.out.println(
                            "Order ID: " + rs.getInt("order_id")
                            + ", Status: " + rs.getString("status")
                            + ", Date: " + rs.getTimestamp("order_date")
                            + ", Product: " + rs.getString("name")
                            + ", Quantity: " + rs.getInt("quantity")
                            + ", Price: " + rs.getDouble("price_at_order")
                    );
                }

                if (!found) {
                    System.out.println("No orders found.");
                }
            }
        }
    }

    // Admin can view all orders
    public void viewAllOrders() throws SQLException {

        String sql =
                "SELECT order_id, customer_id, status, order_date "
                + "FROM orders ORDER BY order_id DESC";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- All Orders ---");

            while (rs.next()) {
                System.out.println(
                        "Order ID: " + rs.getInt("order_id")
                        + ", Customer ID: " + rs.getInt("customer_id")
                        + ", Status: " + rs.getString("status")
                        + ", Date: " + rs.getTimestamp("order_date")
                );
            }
        }
    }

    // Admin can update order status
    public void updateOrderStatus(int orderId, String status)
            throws SQLException {

        if (!List.of("Pending", "Completed", "Delivered", "Cancelled")
                .contains(status)) {
            throw new IllegalArgumentException("Invalid order status.");
        }

        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, orderId);

            if (ps.executeUpdate() > 0) {
                System.out.println("Order status updated successfully!");
            } else {
                System.out.println("Order not found.");
            }
        }
    }
}
