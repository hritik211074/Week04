package com.day02_collection.set_interface;

import java.util.*;

public class FindSubset {

    static boolean findSubset( HashSet<Integer> st1, HashSet<Integer>st2){

        boolean flag=true;
        for(Integer num:st1){
            if(!st2.contains(num)){  // checking element from st1 set into st2 set
                return false;
            }
        }
      return true;
    }
    public static void main(String[] args) {
        // Make the first set
        HashSet<Integer> st1=new HashSet<>();

        // Adding the element in set1
        st1.add(2);
        st1.add(4);

        // Make the first set
        HashSet<Integer>st2=new HashSet<>();
        // Adding the element in set2
        st2.add(1);
        st2.add(2);
        st2.add(3);
        st2.add(4);

        boolean isSubset=findSubset(new HashSet<>(st1),new HashSet<>(st2));

        System.out.println(" Is first set is subset of second set: "+isSubset);
    }
}

