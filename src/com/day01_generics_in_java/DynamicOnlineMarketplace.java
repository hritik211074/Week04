package com.day01_generics_in_java;

// Base category class
abstract class ProductCategory {
    String name;
    ProductCategory(String name) {
        this.name = name;
    }
}

// Specific categories
class BookCategory extends ProductCategory {
    BookCategory() {
        super("Books");
    }
}
class ClothingCategory extends ProductCategory {
    ClothingCategory() {
        super("Clothing");
    }
}

// Generic Product class restricted to ProductCategory
class Product<T extends ProductCategory> {
    String name; double price; T category;

    Product(String name, double price, T category) {
        this.name = name; this.price = price; this.category = category;
    }
    void show() {
        System.out.println(name + " (" + category.name + ") - $" + price);
    }
}

// Generic method to apply discount
class Marketplace {
    static <T extends Product<?>> void applyDiscount(T p, double percent) {

        p.price -= p.price * (percent / 100);

        System.out.println("Discounted Price: $" + p.price);
    }
}

// Example usage
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Guide", 50, new BookCategory());

        book.show();

        Marketplace.applyDiscount(book, 10);

        book.show();
    }
}
