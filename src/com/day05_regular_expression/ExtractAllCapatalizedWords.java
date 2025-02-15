package com.day05_regular_expression;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllCapatalizedWords {

    static ArrayList<String> extractCapatalizedWords(String text){

        ArrayList<String>wordList=new ArrayList<>();
        //Define a regular expression
        String regex= "[A-Z][a-zA-Z]+";
        // Pattern to find the pattern in regex string
        Pattern pp=Pattern.compile(regex);

        //Matcher class to match email string to regex
        Matcher mm=pp.matcher(text);

        // Store the result whether email is valid or not
        while(mm.find()){
            wordList.add(mm.group());
        }
        return wordList;
    }
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Read user input
        System.out.println("Enter the text to find all the capital letter words: ");
        String text = sc.nextLine();
        ArrayList<String>wordList = extractCapatalizedWords(text);

        if (wordList.size() > 0) {
            System.out.println("Word is: ");
            for(int i=0;i<wordList.size();i++){
                System.out.println(i+1+"-> "+wordList.get(i));
            }
        } else {
            System.out.println("No Capital Starting word found");
        }
    }
}
