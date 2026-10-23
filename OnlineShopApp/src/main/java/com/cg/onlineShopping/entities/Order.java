package com.cg.onlineShopping.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
	 private int orderId;
	    private Customer customer;
	    private String status;
	    private List<ProductQuantityPair> products = new ArrayList<>();

	    public Order(int orderId, Customer customer, String status) {
	        this.orderId = orderId;
	        this.customer = customer;
	        this.status = status;
	    }
	    public int getOrderId() { return orderId; }
	    public Customer getCustomer() { return customer; }
	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }
	    public List<ProductQuantityPair> getProducts() { return products; }
	

}
