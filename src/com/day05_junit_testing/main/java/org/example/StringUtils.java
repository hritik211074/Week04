package com.day05_junit_testing.main.java.org.example; // Ensure this matches your project structure

public class StringUtils {
    // Method to reverse a string
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Method to check if a string is a palindrome
    public boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }

    // Method to convert a string to uppercase
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
