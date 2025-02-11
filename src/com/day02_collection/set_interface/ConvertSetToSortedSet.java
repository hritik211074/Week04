package com.day02_collection.set_interface;

import java.util.*;

import java.util.*;

public class ConvertSetToSortedSet {

    static Set<Integer> findSortedSet(HashSet<Integer> st1){
        // Make the set to store the element from set in sorted order
        Set<Integer>sortedSet=new TreeSet<>();

        // Traverse the set and adding the element into sortedSet
        for(Integer num:st1){
           sortedSet.add(num);
        }
        return sortedSet;  // Returning the answer
    }
    public static void main(String[] args) {
        // Make the first set
        HashSet<Integer> st1=new HashSet<>();

        // Adding the element in set1
        st1.add(5);
        st1.add(3);
        st1.add(1);

        // Calling the method to keep all the element in sorted manner
        Set<Integer>sortedSet=findSortedSet(new HashSet<Integer>(st1));

        System.out.println("Sorted order of element is: "+sortedSet);
    }
}