package com.day05_regular_expression;

public class ValidateCreditCard {
    public static boolean isValidCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {

        // Visa credit card number
        String card1 = "4123456789012345";


        // MasterCard example
        String card2 = "5123456789012345";

        // Invalid example
        String card3 = "6123456789012345";

        System.out.println(isValidCard(card1) ? "Valid Card" : "Invalid Card");
        System.out.println(isValidCard(card2) ? "Valid Card" : "Invalid Card");
        System.out.println(isValidCard(card3) ? "Valid Card" : "Invalid Card");
    }
}
