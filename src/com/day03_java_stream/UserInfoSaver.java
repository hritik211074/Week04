package com.day03_java_stream;

import java.io.*;

public class UserInfoSaver {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\flight.txt")) {

            // Read user input
            System.out.print("Enter your name: ");

            String name = reader.readLine();
            System.out.print("Enter your age: ");

            String age = reader.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Write to file
            writer.write("Name: " + name + "\nAge: " + age + "\nFavorite Language: " + language);
            System.out.println("Information saved successfully!");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
