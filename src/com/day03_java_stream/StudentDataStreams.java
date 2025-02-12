package com.day03_java_stream;

import java.io.*;
import java.util.Scanner;

public class StudentDataStreams {
    public static void main(String[] args) {
        String fileName = "students.dat"; // Binary file for storage

        // Write student data to a file
        writeStudentData(fileName);

        // Read and display student data from the file
        readStudentData(fileName);
    }

    // Method to write student data using DataOutputStream
    private static void writeStudentData(String fileName) {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of students: ");
            int numStudents = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int i = 0; i < numStudents; i++) {
                System.out.println("\nEnter details for student " + (i + 1) + ":");
                System.out.print("Roll Number: ");

                int rollNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("GPA: ");
                double gpa = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                // Writing to file
                dos.writeInt(rollNumber);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }

            System.out.println("Student details stored successfully in " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }
    }

    // Method to read student data using DataInputStream
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
