package com.day05_junit_testing.test.java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {
    private final String testFile = "testfile.txt";

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(testFile)); // Clean up after each test
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, File Handling!";
        FileProcessor.writeToFile(testFile, content);

        // Check if the file exists
        assertTrue(Files.exists(Path.of(testFile)));

        // Read content from the file and check if it's correct
        String readContent = FileProcessor.readFromFile(testFile);
        assertEquals(content, readContent);
    }

    @Test
    void testReadFromNonExistentFile() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
    }
}
