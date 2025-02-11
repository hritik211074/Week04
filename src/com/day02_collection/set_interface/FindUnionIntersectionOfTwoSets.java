package com.day02_collection.set_interface;

import java.util.*;

public class FindUnionIntersectionOfTwoSets {

    // Method to find the union of two set
    static List<Integer>findUnion(HashSet<Integer>st1,HashSet<Integer>st2){
        // Make the list to store union
        List<Integer>union=new ArrayList<>();
        for(Integer num:st1){
            if(st2.add(num));  // Adding all element of st1 into st2
        }

        // Adding all element of st2 into list
        for(Integer num:st2){
            union.add(num);
        }
        return union;  // Return the union list
    }

    // Method to find the intersection of two set
    static List<Integer>findIntersection(HashSet<Integer>st1,HashSet<Integer>st2){
        // Make the list to store intersection
        List<Integer>intersection=new ArrayList<>();

        // Traverse the st1 and check the element from st1 is present ini st2 or not if it present we take in intersection list
        for(Integer num:st1){
            if(st2.contains(num)){
                intersection.add(num);
            }
        }
        return intersection;  // Return the intersection list
    }
    public static void main(String[] args) {
        // Make the first set
        HashSet<Integer> st1=new HashSet<>();

        // Adding the element in set1
        st1.add(1);
        st1.add(2);
        st1.add(3);

        // Make the first set
        HashSet<Integer>st2=new HashSet<>();
        // Adding the element in set2
        st2.add(3);
        st2.add(4);
        st2.add(5);

        // Call method to find the union of two set
        List<Integer>union=findUnion(new HashSet<>(st1),new HashSet<>(st2));
        // Displaying the output
        System.out.println("Union of two given set is: "+union);

        // Call the method to find the intersection of two set
        List<Integer>intersection=findIntersection(new HashSet<>(st1),new HashSet<>(st2));
        System.out.println("Intersection of two given set is: "+intersection);

    }
}
