package com.day05_regular_expression;

import java.util.regex.*;

public class ValidateSSN {
    public static boolean isValidSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    public static void main(String[] args) {
        String ssn1 = "123-45-6789";  // Valid SSN
        String ssn2 = "123456789";    // Invalid SSN

        System.out.println(isValidSSN(ssn1) ? ssn1 + " is valid" : " is invalid");

        System.out.println(isValidSSN(ssn2) ? ssn2 + " is valid" : " is invalid");
    }
}

