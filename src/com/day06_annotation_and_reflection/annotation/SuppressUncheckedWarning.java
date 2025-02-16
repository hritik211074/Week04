package com.day06_annotation_and_reflection.annotation;

import java.util.ArrayList;

public class SuppressUncheckedWarning {

    // Suppress unchecked warnings for raw type usage
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Creating an ArrayList without generics (raw type)
        ArrayList rawList = new ArrayList();

        // Adding elements (without type safety)
        rawList.add("Hello");
        rawList.add(100);
        rawList.add(3.14);

        // Retrieving and printing elements
        System.out.println("Raw List Elements: " + rawList);

        // Type casting needed while retrieving elements
        String firstElement = (String) rawList.get(0); // Safe casting

        System.out.println("First Element: " + firstElement);

        // This can cause a runtime exception if the type is incorrect
        try {
            Integer secondElement = (Integer) rawList.get(1); // Correct
            System.out.println("Second Element: " + secondElement);
        } catch (ClassCastException e) {
            System.out.println("Type Mismatch Error: " + e.getMessage());
        }
    }
}
