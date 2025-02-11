package com.day02_collection.list_interface;

import java.util.LinkedList;

public class NthElementFromEnd {
    public static void main(String[] args) {

        // Making the linkedList
        LinkedList<Character>linklist=new LinkedList<>();

        // Adding the Characters
        linklist.add('A');
        linklist.add('B');
        linklist.add('C');
        linklist.add('D');
        linklist.add('E');

        // Taking a position from last
        int position=2;

        // Accessing the character from last
        System.out.println(linklist.get(linklist.size()-position));

    }
}
