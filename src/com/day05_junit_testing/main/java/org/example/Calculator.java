package com.day05_junit_testing.main.java.org.example;

import java.util.*;
public class Calculator {
    public static int addTwoNumber(int a, int b){
        return (a+b);
    }

    public static int subtractTwoNumber(int a,int b){
        return (a-b);
    }
    public static int multiplyTwoNumber(int a,int b){
        return (a*b);
    }
    public static int divisionTwoNumber(int a,int b){
        return (a/b);
    }
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Read two integer value;
        System.out.println("Enter the two number");
        int a=sc.nextInt();
        int b=sc.nextInt();

        // Call method to add two number
        int add=addTwoNumber(a,b);
        System.out.println("Division of two number "+add);

        // Call method to asubtractdd two number
        int subtract=subtractTwoNumber(a,b);
        System.out.println("subtraction of two number "+subtract);

        // Call method to multiplyTwoNumber two number
        int mutiple=multiplyTwoNumber(a,b);
        System.out.println("mutiply of two number "+mutiple);
        try {
            // Call method to division two number
            int division = divisionTwoNumber(a, b);

            System.out.println("Division of two number "+division);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
