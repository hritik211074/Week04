package com.day01_generics_in_java;

import java.util.*;

// Abstract class representing a warehouse item
abstract class WarehouseItem {

    // Encapsulated field
    private String name;

    // Setting the name
    public WarehouseItem(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    @Override
    public String toString() {  // Returns item name as string
        return name;
    }
}

// Specific item types extending WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

// Generic storage class restricted to WarehouseItem types
class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);   // Adds an item to storage
    }

    public List<T> getItems() {

        // Returns unmodifiable list to ensure safety
        return Collections.unmodifiableList(items);
    }
}

// Main warehouse class
public class Warehouse {

    // Wildcard method to display items from any Storage type
    public static void displayItems(List<? extends WarehouseItem> items) {
        items.forEach(item -> System.out.println("Stored: " + item.getName()));
    }

    public static void main(String[] args) {
        // Creating storage for different item categories
        Storage<Electronics> electronicsStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();

        groceriesStorage.addItem(new Groceries("Apple"));
        groceriesStorage.addItem(new Groceries("Banana"));

        Storage<Furniture> furnitureStorage = new Storage<>();

        furnitureStorage.addItem(new Furniture("Table"));
        furnitureStorage.addItem(new Furniture("Chair"));

        // Display all items using wildcard method
        displayItems(electronicsStorage.getItems());

        displayItems(groceriesStorage.getItems());

        displayItems(furnitureStorage.getItems());
    }
}

