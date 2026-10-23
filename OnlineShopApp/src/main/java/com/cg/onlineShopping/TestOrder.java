package com.cg.onlineShopping;

import com.cg.onlineShopping.services.OrderService;

public class TestOrder {

    public static void main(String[] args) {

        OrderService service = new OrderService();

        try {
            service.placeOrder(1001);

            service.viewCustomerOrders(1001);

           
            service.viewAllOrders();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
