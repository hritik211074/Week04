package com.day02_collection.map_interface;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws Exception {
        // Read the file content
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
        for (String word : text.split("\\s+")) { // Split by whitespace
            if (!word.isEmpty()) { // Ensure non-empty words are counted
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Print the original word frequency map
        System.out.println("Word Frequency Map: " + wordCount);

        // Invert the word frequency map
        Map<Integer, List<String>> invertedMap = invertMap(wordCount);

        // Print the inverted map
        System.out.println("Inverted Map: " + invertedMap);
    }

    // Method to invert a Map<K, V> into Map<V, List<K>>
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Store keys in a list for duplicate values
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return inverted;
    }
}

