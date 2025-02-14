package com.day04_exception.unchecked_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticAndInputMismatchException {
    public static void main(String[] args) {
        // Create a scanner object to read a user input
        Scanner sc=new Scanner(System.in);

        try{
            System.out.println("Enter the number ;");
            Integer num=sc.nextInt();
            System.out.println("Square of num is: "+num*num);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        }
    }
}
