package com.day04_exception.exception_propogation;

public class ExceptionPropagationExample {
    // Method that throws an exception for invalid input
    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {

        // Condition in which we have to throw an exception
        if (amount < 0 || rate < 0)
            throw new IllegalArgumentException("Amount and rate must be positive");
        return (amount * rate * years) / 100; // Simple interest formula
    }

    // Main method
    public static void main(String[] args) {
        try {
            // Invalid input (negative rate)
            double interest = calculateInterest(1000, -5, 2);

            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {

            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}

