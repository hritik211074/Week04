package com.day05_regular_expression;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllEmailAddresses {

    static ArrayList<String> extractEmail(String text){

        ArrayList<String>emailList=new ArrayList<>();
        //Define a regular expression
        String regex= "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        // Pattern to find the pattern in regex string
        Pattern pp=Pattern.compile(regex);

        //Matcher class to match email string to regex
        Matcher mm=pp.matcher(text);

        // Store the result whether email is valid or not
        while(mm.find()){
            emailList.add(mm.group());
        }
        return emailList;
    }
    public static void main(String[] args) {
        //Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Read user input
        System.out.println("Enter the text to find all the email: ");
        String text = sc.nextLine();
        ArrayList<String>emailList = extractEmail(text);

        if (emailList.size() > 0) {
            System.out.println("Email is: ");
            for(int i=0;i<emailList.size();i++){
                System.out.println(i+1+"-> "+emailList.get(i));
            }
        } else {
            System.out.println("No email found");
        }
    }
}
