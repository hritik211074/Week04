package com.day05_junit_testing.test.java;
import org.example.PasswordValidator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {


    @Test
    void testValidPasswords() {
        assertTrue(PasswordValidator.isValidPassword("Secure123"));
        assertTrue(PasswordValidator.isValidPassword("HelloWorld1"));
        assertTrue(PasswordValidator.isValidPassword("JavaRocks9"));
    }

    @Test
    void testInvalidShortPassword() {
        assertFalse(PasswordValidator.isValidPassword("Short1"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(PasswordValidator.isValidPassword("password123"));
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(PasswordValidator.isValidPassword("NoDigitsHere"));
    }

    @Test
    void testInvalidPasswordOnlyLowercase() {
        assertFalse(PasswordValidator.isValidPassword("alllowercase"));
    }

    @Test
    void testInvalidNullPassword() {
        assertFalse(PasswordValidator.isValidPassword(null));
    }
}
