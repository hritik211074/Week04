package com.day03_java_stream;

import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\flight.txt" ; // Change this to your actual file path
        String outputFile = "C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\New Text Document.txt";

        try (
                // Using InputStreamReader and OutputStreamWriter for proper encoding
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Maintain line breaks
            }
            System.out.println("File conversion completed successfully!");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
