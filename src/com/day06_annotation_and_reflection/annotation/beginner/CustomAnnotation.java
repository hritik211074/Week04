package com.day06_annotation_and_reflection.annotation.beginner;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define @ImportantMethod annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {

    // Default level is HIGH
    String level() default "HIGH";
}

// Apply annotation to methods
class TaskManager {
    @ImportantMethod(level = "CRITICAL")
    public void urgentTask() {
        System.out.println("Processing urgent task...");
    }

    @ImportantMethod
    public void regularTask() {
        System.out.println("Processing regular task...");
    }
}

// Use Reflection to get annotated methods
public class CustomAnnotation {
    public static void main(String[] args) {

        for (Method method : TaskManager.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println(method.getName() + " (Level: " + annotation.level() + ")");
            }
        }
    }
}
