package com.day06_annotation_and_reflection.annotation.advance;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @RoleAllowed annotation

// Available at runtime
@Retention(RetentionPolicy.RUNTIME)

// Can be used on methods
@Target(ElementType.METHOD)
@interface RoleAllowed {

    // Role required to access the method
    String value();
}

// Simulate a User class with a role
class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Define a SecureService class with restricted methods
class SecureService {

    // Only ADMIN can access this method
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER") // Any USER can access this method
    public void userTask() {
        System.out.println("User task executed successfully!");
    }

    // Method to check access before executing
    public void executeTask(String methodName, User user) {
        try {
            Method method = this.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {

                String requiredRole = method.getAnnotation(RoleAllowed.class).value();

                if (user.getRole().equals(requiredRole)) {
                    method.invoke(this); // Execute method if user has the required role
                } else {
                    System.out.println("Access Denied! " + user.getRole() + " cannot access " + methodName);
                }
            } else {
                System.out.println("No role restrictions found. Executing method...");
                method.invoke(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Step 4: Test Role-Based Access Control
public class RoleBasedAccessControl {
    public static void main(String[] args) {
        SecureService service = new SecureService();

        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        // Admin trying to access adminTask
        System.out.println("🔹 Admin trying to access adminTask:");
        service.executeTask("adminTask", adminUser);

        // Normal user trying to access adminTask
        System.out.println("User trying to access adminTask:");
        service.executeTask("adminTask", normalUser);

        // Normal user trying to access userTask
        System.out.println(" User trying to access userTask:");
        service.executeTask("userTask", normalUser);
    }
}
