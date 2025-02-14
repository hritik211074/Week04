package com.day04_exception.unchecked_exception;

public class ExceptionPropagation {
    // Method that causes an ArithmeticException
    static void method1() {
        int result = 10 / 0; // Throws ArithmeticException
    }

    // Method2 calls method1(), allowing the exception to propagate
    static void method2() {
        method1();
    }

    // Main method calls method2() and handles the exception
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}

