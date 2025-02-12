package com.day03_java_stream;

import java.io.*;
import java.nio.file.*;

public class ImageByteArrayConverter {
    public static void main(String[] args) {

        // Replace with actual image file path
        String inputImage = "C:\\Users\\0111a\\OneDrive\\Pictures\\Camera Roll\\WIN_20250123_15_50_32_Pro.jpg";

        // Output image file
        String outputImage = "C:\\Users\\0111a\\OneDrive\\Pictures\\Camera Roll\\WIN_20250112_13_39_09_Pro.jpg";

        try {
            // Convert image to byte array
            byte[] imageData = convertImageToByteArray(inputImage);

            // Write byte array back to an image file
            writeByteArrayToImage(imageData, outputImage);

            // Verify if the files are identical
            System.out.println(Files.mismatch(Path.of(inputImage), Path.of(outputImage)) == -1
                    ? "Success: Images are identical!" : "Error: Images differ!");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Convert image to byte array using ByteArrayOutputStream
    private static byte[] convertImageToByteArray(String imagePath) throws IOException {

        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) baos.write(buffer, 0, bytesRead);
            return baos.toByteArray();
        }
    }

    // Write byte array back to an image file using ByteArrayInputStream
    private static void writeByteArrayToImage(byte[] imageData, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);

             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) fos.write(buffer, 0, bytesRead);
        }
    }
}

