package com.day04_exception.unchecked_exception;
import java.util.Scanner;

public class ImplementMultipleCatchBlock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accepting array size and elements
        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        Integer[] arr = (size > 0) ? new Integer[size] : null; // Handling null case

        if (arr != null) {
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
        }

        System.out.print("Enter index: ");
        try {
            int index = sc.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
        finally {
            sc.close(); // Close scanner
        }
    }
}
