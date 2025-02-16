package com.day06_annotation_and_reflection.annotation.intermediate;

import java.lang.annotation.*;
import java.lang.reflect.Method;

//  Define @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// Apply annotation to methods
class TaskManager {

    @LogExecutionTime
    public void quickTask() {
        System.out.println("Executing quick task...");
    }

    @LogExecutionTime
    public void longTask() {
        System.out.println("Executing long task...");
        try {
            // Simulate delay
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//  Use Reflection to measure execution time
public class ExecutionLogger {

    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();

        for (Method method : TaskManager.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();  // Start time
                method.invoke(taskManager);      // Call method
                long end = System.nanoTime();    // End time

                System.out.println("⏱️ Execution time of " + method.getName() + ": " + (end - start) / 1_000_000.0 + " ms\n");
            }
        }
    }
}

