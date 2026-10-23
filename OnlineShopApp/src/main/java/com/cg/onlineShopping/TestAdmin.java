package com.cg.onlineShopping;

import com.cg.onlineShopping.entities.Admin;
import com.cg.onlineShopping.services.AdminService;

public class TestAdmin {
	  public static void main(String[] args) {

	        AdminService service = new AdminService();

	        try {
	            Admin admin = new Admin(
	                2001,
	                "AdminOne",
	                "admin2001@example.com"
	            );

	            service.createAdmin(admin);

	            System.out.println("\n--- Admin List ---");

	            for (Admin a : service.getAdmins()) {
	                System.out.println(
	                    "ID: " + a.getUserId()
	                    + ", Name: " + a.getUsername()
	                    + ", Email: " + a.getEmail()
	                );
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
