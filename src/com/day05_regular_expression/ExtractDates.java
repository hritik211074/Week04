package com.day05_regular_expression;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDates {

    static ArrayList<String> extractDatesFromText(String text){

        ArrayList<String>dateList=new ArrayList<>();
        //Define a regular expression

        String regex= "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        // Pattern to find the pattern in regex string
        Pattern pp=Pattern.compile(regex);

        //Matcher class to match text string to regex
        Matcher mm=pp.matcher(text);

        // Store the dates whiich are in text
        while(mm.find()){
            dateList.add(mm.group());
        }
        return dateList;
    }
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Read user input
        System.out.println("Enter the text to find all the dates: ");
        String text = sc.nextLine();

        // Store the dates
        ArrayList<String>dateList = extractDatesFromText(text);

        if (dateList.size() > 0) {
            System.out.println("Email is: ");
            for(int i=0;i<dateList.size();i++){
                System.out.println(i+1+"-> "+dateList.get(i));
            }
        } else {
            System.out.println("No dates found");
        }
    }
}
