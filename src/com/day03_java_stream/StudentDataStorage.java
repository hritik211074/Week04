package com.day03_java_stream;

import java.io.*;

public class StudentDataStorage {
    public static void main(String[] args) {
        String fileName = "students.dat"; // Binary file to store data

        // Writing student data to file
        writeStudentData(fileName);

        // Reading student data from file
        readStudentData(fileName);
    }

    // Method to write student data to a binary file
    private static void writeStudentData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

            // Writing three student records
            dos.writeInt(101); // Roll number
            dos.writeUTF("Alice Johnson"); // Name
            dos.writeDouble(3.8); // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob Smith");
            dos.writeDouble(3.6);

            dos.writeInt(103);
            dos.writeUTF("Charlie Brown");
            dos.writeDouble(3.9);

            System.out.println("Student details stored successfully in " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }
    }

    // Method to read student data from a binary file
    private static void readStudentData(String fileName) {

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {

            System.out.println("\nReading student details from file:");

            while (dis.available() > 0) { // Ensure we don't read past the file
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}

