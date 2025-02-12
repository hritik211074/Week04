package com.day02_collection.map_interface;

import java.util.*;
import java.util.stream.Collectors;

// Creating the Employee class
class Employee {
    // Instance variable
    String name;
    String department;

    // Constructor to initialize the instance vaiable
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name; // Display only the employee's name
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "Finance"),
                new Employee("Eve", "IT")
        );

        // Group employees by department
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department));

        // Print grouped employees
        groupedByDept.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
    }
}

