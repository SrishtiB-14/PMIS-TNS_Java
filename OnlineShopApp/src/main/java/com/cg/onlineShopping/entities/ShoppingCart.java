package com.cg.onlineShopping.entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private final Map<Integer, Integer> items = new HashMap<>();
    public Map<Integer, Integer> getItems() { return items; }
    public void addItem(int productId, int quantity) {
        items.merge(productId, quantity, Integer::sum);
    }
    public void removeItem(int productId) { items.remove(productId); }

}
