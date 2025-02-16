package com.day05_junit_testing.main.java.org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileProcessor {

    // Method to write content to a file
    public static void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // Method to read content from a file
    public static String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
