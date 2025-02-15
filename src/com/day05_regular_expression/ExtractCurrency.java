package com.day05_regular_expression;

import java.util.regex.*;
import java.util.*;

public class ExtractCurrency {
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text whee we want to find the currency: ");
        String text = sc.nextLine();

        // Regex to match currency values (with or without $ sign)
        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");

        Matcher matcher = pattern.matcher(text);

        // Store and print all matches
        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        // Output the extracted currency values
        System.out.println(String.join(", ", currencyValues));
    }
}
