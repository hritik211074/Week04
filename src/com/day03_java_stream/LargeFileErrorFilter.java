package com.day03_java_stream;

import java.io.*;

public class LargeFileErrorFilter {

    public static void main(String[] args) {
        // Replace with the actual large file path
        String filePath = "C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\New Text Document.txt";

        // Read file and print lines containing "error"
        filterErrorLines(filePath);
    }

    // Method to read file line by line and filter "error"
    private static void filterErrorLines(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case-insensitive check
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

