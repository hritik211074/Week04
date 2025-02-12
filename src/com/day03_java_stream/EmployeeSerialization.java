package com.day03_java_stream;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    // Instance variable
    private static final long serialVersionUID = 1L;
    int id;
    String name, department;
    double salary;

    // Constructor to initialize the  instance variable
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }
}

public class EmployeeSerialization {

    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 70000),
                new Employee(2, "Bob", "HR", 50000),
                new Employee(3, "Charlie", "Finance", 60000)
        );

        serializeEmployees(employees);
        deserializeEmployees();
    }

    // Serialize Employee List
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
    }

    // Deserialize Employee List
    private static void deserializeEmployees() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            List<Employee> employees = (List<Employee>) in.readObject();

            System.out.println("Deserialized Employees:");

            employees.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {

            System.err.println("Deserialization error: " + e.getMessage());
        }
    }
}

