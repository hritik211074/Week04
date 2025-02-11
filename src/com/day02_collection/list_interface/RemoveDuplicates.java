package com.day02_collection.list_interface;

import java.util.*;
public class RemoveDuplicates {
    // Method to remove duplicate element
    static List<Integer>removeDuplicate(List<Integer> arr){
      List<Integer>ans=new ArrayList<>();
      for(Integer num:arr){
          if(!ans.contains(num)){  // Check whether element is present in array or not
              ans.add(num);
          }
      }
      return ans;
    }
    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        // Adding the element in list
        arr.add(3);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        // Call a method to remove duplicate from list
        List<Integer>distictElement=removeDuplicate(arr);

        System.out.println("List after removing the duplicate: "+distictElement);
    }
}
