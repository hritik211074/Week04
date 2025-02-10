package com.day01_generics_in_java;



import java.util.*;

// Base class for job roles
abstract class JobRole {

    String name; JobRole(String name) {
        this.name = name;
    }
}

// Specific job roles
class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}
class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}

// Generic Resume class restricted to JobRole
class Resume<T extends JobRole> {
    String candidate; T role;
    Resume(String candidate, T role) {
        this.candidate = candidate; this.role = role;
    }
    void show() {
        System.out.println(candidate + " applying for " + role.name);
    }
}

// Wildcard method to screen multiple resumes
class ScreeningSystem {
    static void screenResumes(List<? extends JobRole> resumes) {
        resumes.forEach(r -> System.out.println("Screening resume for: " + r.name));
    }
}

// Example usage
public class ResumeScreeningSystem {
    public static void main(String[] args) {

        Resume<SoftwareEngineer> seResume = new Resume<>("Alice", new SoftwareEngineer());
        seResume.show();
    }
}
