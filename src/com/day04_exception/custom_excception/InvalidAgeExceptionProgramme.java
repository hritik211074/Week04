package com.day04_exception.custom_excception;

import java.util.Scanner;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }

}
public class InvalidAgeExceptionProgramme {
    static void validate(int age) throws InvalidAgeException {
        if(age<18){
            throw new InvalidAgeException("Age must be above than 18");
        }
    }
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the your age: ");
        int age=sc.nextInt();

        try{
            validate(age);
            System.out.println("You are eligible");

        }catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }
}
