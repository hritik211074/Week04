package com.day05_junit_testing.test.java;

import com.day05_junit_testing.main.java.org.example.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
        assertEquals("", stringUtils.reverse(""));
        assertEquals("a", stringUtils.reverse("a"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));

        assertTrue(stringUtils.isPalindrome("racecar"));

        assertFalse(stringUtils.isPalindrome("hello"));

        assertTrue(stringUtils.isPalindrome("")); // Edge case

        assertTrue(stringUtils.isPalindrome("a")); // Single character is always a palindrome
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));

        assertEquals("WORLD", stringUtils.toUpperCase("world"));

        assertEquals("", stringUtils.toUpperCase("")); // Edge case
        assertEquals("123", stringUtils.toUpperCase("123")); // Numbers remain unchanged
    }
}
