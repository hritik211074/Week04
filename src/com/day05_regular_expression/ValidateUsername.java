package com.day05_regular_expression;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsername {
    static boolean validateEmail(String email){
        //Define a regular expression
        String regex="^[a-zA-Z]+[0-9_]+{5,15}$";

        // Pattern to find the pattern in regex string
        Pattern pp=Pattern.compile(regex);

        //Matcher class to match email string to regex
        Matcher mm=pp.matcher(email);

        // Store the result whether email is valid or not
        boolean result=mm.matches();

        return result;

    }
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc=new Scanner(System.in);

        // Read user input
        System.out.println("Enter the email to  validate");
        String email=sc.nextLine();
        boolean isValid = validateEmail(email);

        if(isValid) System.out.println("Valid Email");
        else System.out.println("Invalid Email");
    }
}
