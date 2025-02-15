package com.day05_regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicensePlateNumber {
    static boolean validatePlateNumber(String plateNumber){
        //Define a regular expression
        String regex="^[A-Z]{2}[0-9]{4}$";

        // Pattern to find the pattern in regex string
        Pattern pp=Pattern.compile(regex);

        //Matcher class to match email string to regex
        Matcher mm=pp.matcher(plateNumber);

        // Store the result whether email is valid or not
        boolean result=mm.matches();

        return result;
    }
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc=new Scanner(System.in);

        // Read user input
        System.out.println("Enter the plate Number to validate: ");
        String plateNumber=sc.nextLine();
        boolean isValid = validatePlateNumber(plateNumber);

        if(isValid) System.out.println("Valid plateNumber");
        else System.out.println("Invalid plateNumber");
    }
}
