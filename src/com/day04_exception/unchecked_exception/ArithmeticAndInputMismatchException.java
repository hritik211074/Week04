package com.day04_exception.unchecked_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticAndInputMismatchException {
    public static void main(String[] args) {
        // Create a scanner object to read a user input
        Scanner sc=new Scanner(System.in);

        try{
            System.out.println("Enter the number two numbers :");

            // Take a two input
            int num1=sc.nextInt();
            int num2=sc.nextInt();

            System.out.println("Division of two integer is"+num1/num2);

            System.out.println("Square of num is: "+num1*num2);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("InputMismatchException error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Some other error: " + e.getMessage());
        }
    }
}
