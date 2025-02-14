package com.day04_exception.unchecked_exception;

import java.util.Scanner;

public class FinallyBlockExample {
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        try {
            // Taking two integers as input
            System.out.print("Enter numerator: ");
            int num = sc.nextInt();  // Read first number as numerator

            System.out.print("Enter denominator: ");
            int denom = sc.nextInt();  // Read user input as denominator

            // Performing division
            int result = num / denom;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } finally {
            System.out.println("Operation completed."); // Always executes
            sc.close(); // Close scanner
        }
    }
}
