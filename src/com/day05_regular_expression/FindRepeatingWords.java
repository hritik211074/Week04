package com.day05_regular_expression;

import java.util.*;
import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";

        // Regex to match words (case-insensitive)
        Pattern pattern = Pattern.compile("\\b\\w+\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);

        // Store word counts
        Map<String, Integer> wordCount = new HashMap<>();

        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase

            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect and print repeating words
        List<String> repeatingWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {

            if (entry.getValue() > 1) {

                repeatingWords.add(entry.getKey()); // Add the repeated words
            }
        }

        System.out.println(String.join(", ", repeatingWords));
    }
}

