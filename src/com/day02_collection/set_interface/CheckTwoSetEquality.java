package com.day02_collection.set_interface;

import java.util.*;
public class CheckTwoSetEquality {
    public static void main(String[] args) {
        // Make the first set
        HashSet<Integer>st1=new HashSet<>();

        // Adding the element in set1
        st1.add(1);
        st1.add(2);
        st1.add(3);

        // Make the first set
        HashSet<Integer>st2=new HashSet<>();
        // Adding the element in set2
        st2.add(3);
        st2.add(2);
        st2.add(1);
        // Checking whether both set are equal or not
        System.out.println(st1.equals(st2));
    }
}
