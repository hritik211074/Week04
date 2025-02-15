package com.day05_regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColorCode {
    static boolean validateHexColorCode(String hexColor){
        //Define a regular expression
        String regex="^#[0-9A-Fa-f]{6}$";

        // Pattern to find the pattern in regex string
        Pattern pp=Pattern.compile(regex);

        //Matcher class to match email string to regex
        Matcher mm=pp.matcher(hexColor);

        // Store the result whether email is valid or not
        boolean result=mm.matches();

        return result;
    }
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc=new Scanner(System.in);

        // Read user input
        System.out.println("Enter the Hex color to validate: ");
        String hexColor=sc.nextLine();
        boolean isValid = validateHexColorCode(hexColor);

        if(isValid) System.out.println("Valid Hex Color Code");
        else System.out.println("Invalid Hex Color Code");
    }
}
