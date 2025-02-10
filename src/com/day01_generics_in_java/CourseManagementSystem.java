package com.day01_generics_in_java;


import java.util.*;

// Base class for course types
abstract class CourseType {
    String name; CourseType(String name) {
        this.name = name;
    }
}

// Specific course types
class ExamCourse extends CourseType {
    ExamCourse() {
        super("Exam Based Task");
    }
}
class AssignmentCourse extends CourseType {
    AssignmentCourse() {
        super("Assignment Based Task");
    }
}

// Generic Course class restricted to CourseType
class Course<T extends CourseType> {
    String title; T type;
    Course(String title, T type) {
        this.title = title; this.type = type;
    }
    void show() {
        System.out.println(title + " (" + type.name + ")");
    }
}

// Method using wildcard to display any course type
class University {
    static void displayCourses(List<? extends CourseType> courses) {

        courses.forEach(c -> System.out.println(c.name));
    }
}

// Example usage
class CourseManagementSystem {

    public static void main(String[] args) {

        Course<ExamCourse> math = new Course<>("Math 101", new ExamCourse());
        math.show();
    }
}
