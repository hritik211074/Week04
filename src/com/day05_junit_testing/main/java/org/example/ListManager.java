package com.day05_junit_testing.main.java.org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManager {
    // Method to add an element to the list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }


    // Method to remove an element from the list
    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    // Method to get the size of the list
    public int getSize(List<Integer> list) {
        return list.size();
    }
}
