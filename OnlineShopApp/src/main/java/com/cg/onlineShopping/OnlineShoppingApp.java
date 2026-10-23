package com.cg.onlineShopping;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cg.onlineShopping.entities.Admin;
import com.cg.onlineShopping.entities.Customer;
import com.cg.onlineShopping.entities.Product;
import com.cg.onlineShopping.services.AdminService;
import com.cg.onlineShopping.services.CustomerService;
import com.cg.onlineShopping.services.OrderService;
import com.cg.onlineShopping.services.ProductService;

public class OnlineShoppingApp {
	 private static final Scanner sc = new Scanner(System.in);

	    private static final CustomerService customerService =
	            new CustomerService();
	    private static final AdminService adminService =
	            new AdminService();
	    private static final ProductService productService =
	            new ProductService();
	    private static final OrderService orderService =
	            new OrderService();

	    public static void main(String[] args) {

	        boolean running = true;

	        while (running) {
	            System.out.println("\n===== ONLINE SHOPPING APPLICATION =====");
	            System.out.println("1. Customer Menu");
	            System.out.println("2. Admin Menu");
	            System.out.println("3. Exit");
	            System.out.print("Enter choice: ");

	            int choice = readInt();

	            try {
	                switch (choice) {
	                    case 1 : customerMenu(); break;
	                    case 2 : adminMenu(); break;
	                    case 3 : {
	                        running = false;
	                        System.out.println("Thank you for shopping!");
	                    } break;
	                    default : System.out.println("Invalid choice!");
	                }
	            } catch (SQLException e) {
	                System.out.println("Database error: " + e.getMessage());
	            } catch (IllegalArgumentException e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }

	        sc.close();
	    }

	    private static void customerMenu() throws SQLException {

	        boolean back = false;

	        while (!back) {
	            System.out.println("\n--- CUSTOMER MENU ---");
	            System.out.println("1. Register Customer");
	            System.out.println("2. View Customers");
	            System.out.println("3. Browse Products");
	            System.out.println("4. Add Product to Cart");
	            System.out.println("5. View Cart");
	            System.out.println("6. Remove Product from Cart");
	            System.out.println("7. Place Order");
	            System.out.println("8. View My Orders");
	            System.out.println("9. Back");
	            System.out.print("Enter choice: ");

	            int choice = readInt();

	            switch (choice) {
	                case 1 : {
	                    System.out.print("Customer ID: ");
	                    int id = readInt();
	                    System.out.print("Username: ");
	                    String name = sc.nextLine();
	                    System.out.print("Email: ");
	                    String email = sc.nextLine();
	                    System.out.print("Address: ");
	                    String address = sc.nextLine();

	                    customerService.createCustomer(
	                            new Customer(id, name, email, address));
	                } break;
	                case 2 : {
	                    for (Customer c : customerService.getCustomers()) {
	                        System.out.println(
	                                "ID: " + c.getUserId()
	                                + ", Name: " + c.getUsername()
	                                + ", Email: " + c.getEmail()
	                                + ", Address: " + c.getAddress());
	                    }
	                } break;
	                case 3 : showProducts(); break;
	                case 4 : {
	                    System.out.print("Your Customer ID: ");
	                    int customerId = readInt();
	                    System.out.print("Product ID: ");
	                    int productId = readInt();
	                    System.out.print("Quantity: ");
	                    int quantity = readInt();

	                    customerService.addToCart(
	                            customerId, productId, quantity);
	                } break;
	                case 5 : {
	                    System.out.print("Your Customer ID: ");
	                    customerService.viewCart(readInt());
	                } break;
	                case 6 : {
	                    System.out.print("Your Customer ID: ");
	                    int customerId = readInt();
	                    System.out.print("Product ID to remove: ");
	                    int productId = readInt();

	                    customerService.removeFromCart(
	                            customerId, productId);
	                } break;
	                case 7 : {
	                    System.out.print("Your Customer ID: ");
	                    orderService.placeOrder(readInt());
	                } break;
	                case 8 : {
	                    System.out.print("Your Customer ID: ");
	                    orderService.viewCustomerOrders(readInt());
	                } break;
	                case 9 : back = true; break;
	                default : System.out.println("Invalid choice!");
	            }
	        }
	    }

	    private static void adminMenu() throws SQLException {

	        boolean back = false;

	        while (!back) {
	            System.out.println("\n--- ADMIN MENU ---");
	            System.out.println("1. Register Admin");
	            System.out.println("2. View Admins");
	            System.out.println("3. Add Product");
	            System.out.println("4. View Products");
	            System.out.println("5. Update Product");
	            System.out.println("6. Remove Product");
	            System.out.println("7. View All Orders");
	            System.out.println("8. Update Order Status");
	            System.out.println("9. Back");
	            System.out.print("Enter choice: ");

	            int choice = readInt();

	            switch (choice) {
	                case 1: {
	                    System.out.print("Admin ID: ");
	                    int id = readInt();
	                    System.out.print("Username: ");
	                    String name = sc.nextLine();
	                    System.out.print("Email: ");
	                    String email = sc.nextLine();

	                    adminService.createAdmin(
	                            new Admin(id, name, email));
	                } break;
	                case 2 : {
	                    for (Admin a : adminService.getAdmins()) {
	                        System.out.println(
	                                "ID: " + a.getUserId()
	                                + ", Name: " + a.getUsername()
	                                + ", Email: " + a.getEmail());
	                    }
	                } break;
	                case 3: {
	                    System.out.print("Product ID: ");
	                    int id = readInt();
	                    System.out.print("Product Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Price: ");
	                    double price = readDouble();
	                    System.out.print("Stock Quantity: ");
	                    int stock = readInt();

	                    productService.addProduct(
	                            new Product(id, name, price, stock));
	                } break;
	                case 4 : showProducts(); break;
	                case 5 : {
	                    System.out.print("Product ID to update: ");
	                    int id = readInt();
	                    System.out.print("New Product Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("New Price: ");
	                    double price = readDouble();
	                    System.out.print("New Stock Quantity: ");
	                    int stock = readInt();

	                    boolean updated = productService.updateProduct(
	                            new Product(id, name, price, stock));

	                    if (!updated) {
	                        System.out.println("Product not found.");
	                    }
	                } break;
	                case 6 : {
	                    System.out.print("Product ID to remove: ");
	                    int id = readInt();

	                    if (!productService.removeProduct(id)) {
	                        System.out.println("Product not found.");
	                    }
	                } break;
	                case 7: orderService.viewAllOrders(); break;
	                case 8 : {
	                    System.out.print("Order ID: ");
	                    int orderId = readInt();
	                    System.out.print(
	                            "New Status (Pending/Completed/Delivered/Cancelled): ");
	                    String status = sc.nextLine();

	                    orderService.updateOrderStatus(orderId, status);
	                } break;
	                case 9: back = true; break;
	                default : System.out.println("Invalid choice!");
	            }
	        }
	    }

	    private static void showProducts() throws SQLException {
	        List<Product> products = productService.getProducts();

	        System.out.println("\n--- Available Products ---");

	        if (products.isEmpty()) {
	            System.out.println("No products available.");
	        } else {
	            for (Product p : products) {
	                System.out.println(p);
	            }
	        }
	    }

	    private static int readInt() {
	        while (!sc.hasNextInt()) {
	            System.out.print("Enter a valid integer: ");
	            sc.nextLine();
	        }

	        int value = sc.nextInt();
	        sc.nextLine();
	        return value;
	    }

	    private static double readDouble() {
	        while (!sc.hasNextDouble()) {
	            System.out.print("Enter a valid number: ");
	            sc.nextLine();
	        }

	        double value = sc.nextDouble();
	        sc.nextLine();
	        return value;
	    }
	
}
