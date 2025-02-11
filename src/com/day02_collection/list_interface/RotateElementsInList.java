package com.day02_collection.list_interface;

import java.util.ArrayList;
import java.util.List;

public class RotateElementsInList {
    static void rotateList( List<Integer> arr,int rotationPoint){
        int i=0;  // Initializing i with zero

        // Doing the left rotation by 2
        while(i<rotationPoint){
            int temp=arr.get(0);  // Geeting the first
            arr.remove(0);  // Deleting the first
            arr.add(temp);   // Insert at last
            i++;
        }
    }
    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        // Adding the element in list
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);

        int rotationPoint=2;  //  Rotate by 2

        // Call the method to rotate the array
        rotateList(arr,rotationPoint);

        // Printing the list after rotation
        System.out.println("List after the rotation: "+arr);
    }
}
