package com.day02_collection.list_interface;

import java.util.*;

public class FrequencyOfElement {
    public static void main(String[] args) {
        // Making the list to store string
        List<String>list=new ArrayList<>();

        // Adding the string
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");

        // Creating the map of string vs integer to store the frequency of string
        HashMap<String,Integer>mp=new HashMap<>();

        // Traversing the list
        for(String st:list){
            if(mp.containsKey(st)){
                mp.put(st,mp.get(st)+1);  // Increasing the frequency by one
            }else{
                mp.put(st,1);   // If absent
            }
        }
        System.out.println(mp);
    }
}
