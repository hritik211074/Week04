package com.day02_collection.map_interface;

import java.io.*;
import java.util.*;

public class MergeTwoMap {
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

        // Example maps to merge
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);

        // Merge maps and print the result
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);
        System.out.println("Merged Map: " + mergedMap);
    }

    // Method to merge two maps and sum values of duplicate keys
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1); // Start with map1 data

        map2.forEach((key, value) ->
                merged.merge(key, value, Integer::sum) // Merge values by summing
        );

        return merged;
    }
}
