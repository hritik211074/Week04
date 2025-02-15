package com.day05_regular_expression;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultipleSpacesWithSingleSpace {

    static String replaceMultipleSpaceWithSingleSpace(String text){

        //Define a regular expression
        String regex= "\\s+";
        // Pattern to find the pattern in regex string
        Pattern pp=Pattern.compile(regex);

        //Matcher class to match text string to regex
        Matcher mm=pp.matcher(text);

        // Store the link which are in text
        String result = mm.replaceAll(" ");
        return result;
    }
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Read user input
        System.out.println("Enter the text to find all the link: ");
        String text = sc.nextLine();

        // Store the dates
        String result = replaceMultipleSpaceWithSingleSpace(text);

        System.out.println("Modified string is: "+result);
    }
}
