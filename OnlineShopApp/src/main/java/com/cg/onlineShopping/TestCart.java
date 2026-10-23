package com.cg.onlineShopping;

import com.cg.onlineShopping.services.CustomerService;

public class TestCart {

    public static void main(String[] args) {

        CustomerService service = new CustomerService();

        try {
            // Customer ID 1001 already created in our earlier test
            // Product ID 101 was added in our earlier product test
            service.addToCart(1001, 101, 2);

            service.viewCart(1001);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
