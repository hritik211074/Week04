package com.day06_annotation_and_reflection.annotation.beginner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import static java.lang.annotation.ElementType.METHOD;

// Define the @Todo annotation

// Annotation will be available at runtime
@Retention(RetentionPolicy.RUNTIME)

// This annotation can only be used on methods
@Target(METHOD)
@interface Todo {
    String task(); // Task description
    String assignedTo(); // Developer responsible for completing it
    String priority() default "MEDIUM"; // Default priority is "MEDIUM"
}

// Create a class and apply @Todo annotation to pending tasks
class ProjectTasks {

    @Todo(task = "Implement login functionality", assignedTo = "Alice", priority = "HIGH")
    public void implementLogin() {
        System.out.println("Work in progress: Implementing login...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Work in progress: Optimizing database queries...");
    }

    @Todo(task = "Improve UI design", assignedTo = "Charlie", priority = "LOW")
    public void improveUI() {
        System.out.println("Work in progress: Improving UI design...");
    }
}

// Retrieve and print all pending tasks using Reflection
public class TodoAnnotation{
    public static void main(String[] args) {
        try {
            // Get the ProjectTasks class
            Class<ProjectTasks> obj = ProjectTasks.class;

            // Iterate through all declared methods
            for (Method method : obj.getDeclaredMethods()) {
                // Check if @Todo annotation is present on the method
                if (method.isAnnotationPresent(Todo.class)) {
                    // Retrieve the annotation
                    Todo todoAnnotation = method.getAnnotation(Todo.class);

                    // Print the task details
                    System.out.println("Pending Task: " + todoAnnotation.task());
                    System.out.println("Assigned To: " + todoAnnotation.assignedTo());
                    System.out.println("Priority: " + todoAnnotation.priority());
                    System.out.println("Method: " + method.getName());
                    System.out.println("----------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
