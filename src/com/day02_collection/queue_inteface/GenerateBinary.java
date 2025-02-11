package com.day02_collection.queue_inteface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

 public class GenerateBinary {
    static Queue<String> binaryFind(int num) {
        Queue<String> binary = new LinkedList<>();

        for (int i = 1; i <= num; i++) { // Fix: Include 'num' itself
            int temp = i;
            StringBuilder sb = new StringBuilder();

            while (temp != 0) {
                sb.append((char)((temp & 1) + '0')); // Append bits (in reverse order)
                temp = temp >> 1;
            }

            binary.add(sb.reverse().toString()); // Reverse to correct order before storing
        }
        return binary;  // Returning the answer
    }

    public static void main(String[] args) {

        // Create the scanner object to read user input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int num = sc.nextInt(); // Store the user input

        // Call method to find all the binary from 1 to num
        Queue<String> binary = binaryFind(num);

        ///  Display the result
        System.out.println("All binary numbers: " + binary);
    }
}
