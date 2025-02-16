package com.day06_annotation_and_reflection.annotation.intermediate;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation

// Available at runtime
@Retention(RetentionPolicy.RUNTIME)

// Can be used on fields
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();  // Max length limit
}

// Create a User class with validation in the constructor
class User {

    // Restrict username length to 10 characters
    @MaxLength(10)
    private String username;

    // Constructor with validation
    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    // Method to check field length using reflection
    private void validateMaxLength(String value) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (value.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength + " characters!");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

//  Test the validation
public class MaxLengthValidator {
    public static void main(String[] args) {
        try {
            User user1 = new User("Hritik");  // Valid
            System.out.println("✅ User created: " + user1);

            User user2 = new User("Hritik Kumar Maurya");  // Too long, will throw an error
            System.out.println("✅ User created: " + user2);
        } catch (IllegalArgumentException e) {

            // Print validation error
            System.out.println(e.getMessage());
        }
    }
}
