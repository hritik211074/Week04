package com.day06_annotation_and_reflection.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define a custom annotation @TaskInfo
@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    // Priority of the task
    String priority();

    // Person responsible
    String assignedTo();
}

// Create a class TaskManager and apply @TaskInfo annotation
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}

//  Retrieve and display annotation details using Reflection API
public class CustomAnnotation {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<TaskManager> obj = TaskManager.class;

            // Get the method that has the annotation
            Method method = obj.getMethod("completeTask");

            // Check if @TaskInfo annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {

                // Retrieve the annotation
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Display annotation details
                System.out.println("Task Details:");

                System.out.println(" Priority: " + taskInfo.priority());

                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

