package com.day02_collection.set_interface;

import java.util.*;

public class SymmetricDifference {

    static List<Integer>findSymmetryDIfference(HashSet<Integer>st1,HashSet<Integer>st2){
        // Make the list to store symmetry difference of two set
        List<Integer>symmetryDifference=new ArrayList<>();

        for(Integer num:st1){
            if(!st2.contains(num)){  // checking element from st1 set into st2 set
                symmetryDifference.add(num);
            }
        }

        for(Integer num:st2){
            if(!st1.contains(num)){   // checking element from st1 set into st2 set
                symmetryDifference.add(num);
            }
        }
        return symmetryDifference;  // Returning the ans which contains the symmetry difference element
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

        List<Integer>symmetryDifference=findSymmetryDIfference(new HashSet<Integer>(st1),new HashSet<Integer>(st2));

        System.out.println("Symmetry difference of two set is: "+symmetryDifference);
    }
}
