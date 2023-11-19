package com.service;

import com.model.Product;

public class ProductService {

    public Product increasePriceByCategory(Product p) {
        double increment = 0.0;

        // Check category and apply increment
        if ("Mobiles".equalsIgnoreCase(p.getCategory())) {
            increment = 0.02; // 2%
        } else if ("Laptops".equalsIgnoreCase(p.getCategory())) {
            increment = 0.01; // 1%
        }

        // Increase the price
        double increasedPrice = p.getPrice() * (1 + increment);
        p.setPrice(increasedPrice);

        return p;
    }

    public double computeTotalPrice(Product[] products) {
        double totalPrice = 0.0;

        for (Product product : products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public void computeGreaterPrice(Product p1, Product p2) {
        if (p1.getPrice() > p2.getPrice()) {
            System.out.println(p1.getTitle() + " has a greater price.");
        } else if (p1.getPrice() < p2.getPrice()) {
            System.out.println(p2.getTitle() + " has a greater price.");
        } else {
            System.out.println("Both products have the same price.");
        }
    }

}
