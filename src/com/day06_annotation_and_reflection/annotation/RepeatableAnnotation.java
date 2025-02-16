package com.day06_annotation_and_reflection.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import static java.lang.annotation.ElementType.METHOD;

// Step 1: Define a container annotation for repeatability
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
@interface BugReports {
    BugReport[] value();  // Array to hold multiple @BugReport annotations
}

// Step 2: Define the repeatable annotation @BugReport
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
@Repeatable(BugReports.class)  // Allows multiple @BugReport annotations
@interface BugReport {
    String description();
}

// Create a class and apply @BugReport multiple times
class SoftwareModule {

    @BugReport(description = "NullPointerException occurs when input is null")
    @BugReport(description = "Performance issue when processing large data")
    public void processData() {
        System.out.println("Processing data...");
    }
}

//  Retrieve and print all bug reports using Reflection API
public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            // Get the SoftwareModule class
            Class<SoftwareModule> obj = SoftwareModule.class;

            // Get the method that has the annotation
            Method method = obj.getMethod("processData");

            // Check if the method has multiple @BugReport annotations
            if (method.isAnnotationPresent(BugReports.class)) {

                // Retrieve all BugReport annotations
                BugReports bugReports = method.getAnnotation(BugReports.class);

                System.out.println("Bug Reports:");

                for (BugReport bug : bugReports.value()) {
                    System.out.println( bug.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

