package com.cg.onlineShopping.services;

import com.cg.onlineShopping.entities.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminService {
	 private static final String URL =
	            "jdbc:mysql://localhost:3306/online_shopping";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root8";

	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

	    public void createAdmin(Admin admin) throws SQLException {

	        String userSql =
	                "INSERT INTO users (user_id, username, email, role) "
	                + "VALUES (?, ?, ?, 'ADMIN')";

	        String adminSql =
	                "INSERT INTO admins (user_id) VALUES (?)";

	        try (Connection con = getConnection()) {
	            con.setAutoCommit(false);

	            try {
	                try (PreparedStatement ps =
	                        con.prepareStatement(userSql)) {
	                    ps.setInt(1, admin.getUserId());
	                    ps.setString(2, admin.getUsername());
	                    ps.setString(3, admin.getEmail());
	                    ps.executeUpdate();
	                }

	                try (PreparedStatement ps =
	                        con.prepareStatement(adminSql)) {
	                    ps.setInt(1, admin.getUserId());
	                    ps.executeUpdate();
	                }

	                con.commit();
	                System.out.println("Admin created successfully!");

	            } catch (SQLException e) {
	                con.rollback();
	                throw e;
	            }
	        }
	    }

	    public List<Admin> getAdmins() throws SQLException {

	        List<Admin> admins = new ArrayList<>();

	        String sql =
	                "SELECT u.user_id, u.username, u.email "
	                + "FROM users u JOIN admins a "
	                + "ON u.user_id = a.user_id";

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                admins.add(new Admin(
	                        rs.getInt("user_id"),
	                        rs.getString("username"),
	                        rs.getString("email")
	                ));
	            }
	        }

	        return admins;
	    }

}
