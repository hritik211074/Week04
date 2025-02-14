package com.day04_exception.custom_excception;

import java.util.Scanner;

// Create a custom Exception
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);  // call super class parametrized constructor
    }

}
public class InvalidAgeExceptionProgramme {

    // Method to validate the age
    static void validate(int age) throws InvalidAgeException {
        if(age<18){
            throw new InvalidAgeException("Age must be above than 18");  // throw the exception
        }
    }
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the your age: ");
        int age=sc.nextInt();

        try{
            validate(age);  //  calling the method to validate age
            System.out.println("You are eligible");

        }catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }
}
