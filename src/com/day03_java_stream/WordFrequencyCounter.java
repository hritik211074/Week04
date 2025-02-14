package com.day03_java_stream;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Replace with the actual file path
        String filePath = "C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\New Text Document.txt";

        // Count words and display top 5
        countWordsAndDisplayTop5(filePath);
    }

    // Method to count words and display top 5 most frequent words
    private static void countWordsAndDisplayTop5(String filePath) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Normalize text: convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z ]", "");

                // Split line into words
                String[] words = line.split("\\s+");

                // Count occurrences of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Display total word count
            int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();

            System.out.println("Total words in file: " + totalWords);

            // Sort words by frequency (descending order)
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());

            sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Display top 5 most frequent words
            System.out.println("\nTop 5 most frequent words:");

            for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                Map.Entry<String, Integer> entry = sortedWords.get(i);
                System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

