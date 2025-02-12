package com.day02_collection.map_interface;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws Exception {
        // Use BufferedReader instead of Files.readString
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\flight.txt")
        );
        StringBuilder sb = new StringBuilder();

        String line;

        // Read file line by line
        while ((line = reader.readLine()) != null) {
            sb.append(line).append(" ");
        }
        reader.close();

        // Convert to string
        String text = sb.toString().toLowerCase().replaceAll("[^a-z ]", "");

        // Create a HashMap to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        // Split text into words and count occurrences
        for (String word : text.split("\\s+")) { // Split by whitespace
            if (!word.isEmpty()) { // Ensure non-empty words are counted
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Print the word frequency map
        System.out.println(wordCount);
    }
}

