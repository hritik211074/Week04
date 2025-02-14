package com.day04_exception.checked_exception;

import java.io.*;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Try-with-resources to auto-close BufferedReader

        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {

            System.out.println("First line: " + br.readLine()); // Read and print first line

        }   catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

