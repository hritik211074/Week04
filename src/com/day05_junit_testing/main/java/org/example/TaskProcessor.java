package com.day05_junit_testing.main.java.org.example;

public class TaskProcessor {
    public static String longRunningTask() {
        try {
            Thread.sleep(3000); // Simulate a long-running task (3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}
