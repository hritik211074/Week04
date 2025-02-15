package com.day05_regular_expression;

import java.util.*;
import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";

        // List of bad words to censor
        List<String> badWords = Arrays.asList("damn", "stupid");

        // Censor the sentence using regex
        String censoredSentence = censorWithRegex(sentence, badWords);

        // Print the censored sentence
        System.out.println(censoredSentence);
    }

    public static String censorWithRegex(String sentence, List<String> badWords) {

        // Create a regex pattern that matches any bad word as a full word (\b ensures word boundaries)
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);

        // Replace all matches with stars of the same length
        StringBuffer censoredSentence = new StringBuffer();
        while (matcher.find()) {

            String stars = "*".repeat(matcher.group().length());
            matcher.appendReplacement(censoredSentence, stars);
        }
        matcher.appendTail(censoredSentence);

        return censoredSentence.toString();
    }
}
