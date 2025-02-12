package com.day03_java_stream;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // Source and Destination file paths
        String sourceFile = "C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\flight.txt";

        String destinationFile = "C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\moveAllALeftsie";


        // FileInputStream to read the source file
        try (FileInputStream fis = new FileInputStream(sourceFile);

             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            // Read from source and write to destination byte by byte
            while ((byteData = fis.read()) != -1) {

                fos.write(byteData);
            }
            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {  // Catch the exception when it occur

            System.out.println("Error: Source file not found.");

        } catch (IOException e) {

            System.out.println("Error: An IO exception occurred.");
        }
    }
}

