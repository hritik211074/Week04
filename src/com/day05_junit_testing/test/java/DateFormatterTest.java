package com.day05_junit_testing.test.java;
import org.example.DateFormatter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
        assertEquals("15-08-1947", DateFormatter.formatDate("1947-08-15"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("12-25-2023"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("25/12/2023"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2023/12/25"));
    }

    @Test
    void testEmptyAndNullInput() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(""));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(null));
    }
}
