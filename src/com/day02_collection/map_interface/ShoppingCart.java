package com.day02_collection.map_interface;

import java.util.*;

public class ShoppingCart {

    // Store product prices
    Map<String, Double> productPrices = new HashMap<>();

    // Maintain order of added items
    LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    // Sort items by price
    TreeMap<Double, String> sortedCart = new TreeMap<>();

    void addProduct(String product, double price, int quantity) {
        productPrices.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        sortedCart.put(price, product);
    }

    void displayCart() {
        System.out.println("Cart (Order Added): " + cart);
        System.out.println("Cart (Sorted by Price): " + sortedCart);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Apple", 1.50, 2);
        cart.addProduct("Banana", 0.75, 5);
        cart.addProduct("Orange", 1.25, 3);
        cart.addProduct("Grapes", 2.00, 1);

        cart.displayCart();
    }
}