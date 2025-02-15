package com.day05_regular_expression;

import java.util.Scanner;

public class ValidateCreditCard {
    public static boolean isValidCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the card number");
        String card1=sc.nextLine();

        System.out.println(isValidCard(card1) ? "Valid Card" : "Invalid Card");
    }
}
