package com.cg.onlineShopping.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL =
            "jdbc:mysql://localhost:3306/online_shopping";

    private static final String USER = "root";

    private static final String PASSWORD = "Srishpass@143";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            System.out.println("MySQL Connected Successfully!");
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }

}
