package com.day02_collection.map_interface;
import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws Exception {
        // Read file content
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\flight.txt"));
        StringBuilder sb = new StringBuilder();
        String line;

        // Read file line by line
        while ((line = reader.readLine()) != null) {
            sb.append(line).append(" ");
        }
        reader.close();

        // Convert text to lowercase and remove punctuation
        String text = sb.toString().toLowerCase().replaceAll("[^a-z ]", "");

        // Create a HashMap to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        // Split text into words and count occurrences
        for (String word : text.split("\\s+")) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Print the word frequency map
        System.out.println("Word Frequency Map: " + wordCount);

        // Find the word with the highest frequency using Java Streams
        String mostFrequentWord = wordCount.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()) // Get the entry with the highest value
                .map(Map.Entry::getKey) // Extract the key (word)
                .orElse("No words found"); // Handle empty case

        // Print the most frequent word
        System.out.println("Most Frequent Word: " + mostFrequentWord);
    }
}
