package com.day05_junit_testing.test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
class ListManagerTest {
    private ListManager listManager;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        testList = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        listManager.addElement(testList, 5);
        assertTrue(testList.contains(5));
    }

    @Test
    void testRemoveElement() {
        testList.add(10);
        listManager.removeElement(testList, 10);
        assertFalse(testList.contains(10));
    }

    @Test
    void testGetSize() {
        listManager.addElement(testList, 1);
        listManager.addElement(testList, 2);
        assertEquals(2, listManager.getSize(testList));
        listManager.removeElement(testList, 1);
        assertEquals(1, listManager.getSize(testList));
    }
}
