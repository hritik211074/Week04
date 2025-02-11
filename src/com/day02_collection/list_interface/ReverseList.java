package com.day02_collection.list_interface;
import java.util.*;
public class ReverseList {
    static void reverseListUsingArrayList(List<Integer>arr1){
        int i=0;
        int j=arr1.size()-1;
        while(i<j){
            int temp=arr1.get(i);
            arr1.set(i,arr1.get(j));
            arr1.set(j,temp);
            i++;
            j--;
        }
    }
    static void reverseListUsingLinkedList(List<Integer>arr2){
        int i=0;
        int j=arr2.size()-1;
        while(i<j){
            int temp=arr2.get(i);
            arr2.set(i,arr2.get(j));
            arr2.set(j,temp);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        // Implemented using arrayList
        List<Integer>arr1=new ArrayList<>();

        // Adding the element in,list
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);

        // Call method to reverse the list
        reverseListUsingArrayList(arr1);
        System.out.println("Reverse of list by using ArrayList is-> "+arr1);  // printing the list

        // Implemented using arrayList
        List<Integer>arr2=new ArrayList<>();
        // Adding the element in list
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);
        // Call method to reverse the list
        reverseListUsingLinkedList(arr2);
        System.out.println("Reverse of list by using LinkedList is-> "+arr2);  // Printing the list

    }
}
