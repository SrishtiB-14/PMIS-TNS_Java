package com.cg.onlineShopping.entities;


public class Customer extends User {

    private String address;
    private ShoppingCart shoppingCart;

    public Customer(int userId, String username, String email, String address) {
        super(userId, username, email);
        this.address = address;
        this.shoppingCart = new ShoppingCart();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        return super.toString() + ", Address: " + address;
    }
	
}
