package com.day05_regular_expression;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {

    static ArrayList<String> extractlink(String text){

        ArrayList<String>linkList=new ArrayList<>();
        //Define a regular expression

        String regex= "http[s]*://[a-z0-9.]+[a-zA-Z]{2,}";
        // Pattern to find the pattern in regex string
        Pattern pp=Pattern.compile(regex);

        //Matcher class to match text string to regex
        Matcher mm=pp.matcher(text);

        // Store the link which are in text
        while(mm.find()){
            linkList.add(mm.group());
        }
        return linkList;
    }
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Read user input
        System.out.println("Enter the text to find all the link: ");
        String text = sc.nextLine();

        // Store the dates
        ArrayList<String>linkList = extractlink(text);

        if (linkList.size() > 0) {
            System.out.println("Email is: ");
            for(int i=0;i<linkList.size();i++){
                System.out.println(i+1+"-> "+linkList.get(i));
            }
        } else {
            System.out.println("No link found");
        }
    }
}
