package com.day05_junit_testing.test.java;
import org.example.UserRegistration;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertEquals("User registered successfully!",
                UserRegistration.registerUser("JohnDoe", "john.doe@example.com", "SecurePass123"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("", "john.doe@example.com", "SecurePass123"));
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser(null, "john.doe@example.com", "SecurePass123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("JohnDoe", "invalid-email", "SecurePass123"));
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("JohnDoe", "john.doe@com", "SecurePass123"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("JohnDoe", "john.doe@example.com", "12345"));
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("JohnDoe", "john.doe@example.com", ""));
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser(null, null, null));
    }
}
