package com.cg.onlineShopping;

import com.cg.onlineShopping.entities.Product;
import com.cg.onlineShopping.services.ProductService;

public class TestProduct{

    public static void main(String[] args) {

        ProductService service = new ProductService();

        try {
            Product p = new Product(101, "T-Shirt", 560.0, 100);

            service.addProduct(p);

            System.out.println("\nAvailable Products:");

            for (Product product : service.getProducts()) {
                System.out.println(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
  
