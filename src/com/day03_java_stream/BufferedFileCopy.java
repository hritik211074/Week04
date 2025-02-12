package com.day03_java_stream;

import java.io.*;
import java.nio.file.*;

public class BufferedFileCopy {

    public static void main(String[] args) throws IOException {

        String source = "C:\\Users\\0111a\\OneDrive\\Desktop\\Diagram\\flight.txt";

        String destBuffered = "bufferedCopy.dat";
        String destUnbuffered = "unbufferedCopy.dat";

        // Measure Buffered Stream Copy
        long start = System.nanoTime();
        copyFile(source, destBuffered, true);
        long bufferedTime = System.nanoTime() - start;

        // Measure Unbuffered Stream Copy
        start = System.nanoTime();
        copyFile(source, destUnbuffered, false);
        long unbufferedTime = System.nanoTime() - start;

        // Printing the results
        System.out.println("Buffered Copy Time: " + bufferedTime / 1_000_000 + " ms");
        System.out.println("Unbuffered Copy Time: " + unbufferedTime / 1_000_000 + " ms");
    }

    // Generic file copy method with option for buffered/unbuffered
    private static void copyFile(String src, String dest, boolean useBuffer) throws IOException {

        try (InputStream in = useBuffer ? new BufferedInputStream(Files.newInputStream(Path.of(src)))
                : Files.newInputStream(Path.of(src));
             OutputStream out = useBuffer ? new BufferedOutputStream(Files.newOutputStream(Path.of(dest)))
                     : Files.newOutputStream(Path.of(dest))) {
            byte[] buffer = new byte[4096]; // 4KB buffer

            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) out.write(buffer, 0, bytesRead);
        }
    }
}
