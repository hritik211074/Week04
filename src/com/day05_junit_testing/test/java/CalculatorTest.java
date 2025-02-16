package com.day05_junit_testing.test.java;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class CalculatorTest {
    Calculator calculator=new Calculator();

    @Test
    public void add(){
        assertEquals(5,calculator.addTwoNumber(2,3));
        assertEquals(6,calculator.addTwoNumber(3,3));
    }

    @Test
    public void subtract(){
        assertEquals(4,calculator.subtractTwoNumber(7,3));
        assertEquals(6,calculator.subtractTwoNumber(9,3));
    }

    @Test
    public void multiply(){
        assertEquals(6,calculator.multiplyTwoNumber(2,3));
        assertEquals(6,calculator.multiplyTwoNumber(2,3));
    }

    @Test
    public void division(){
        assertEquals(5,calculator.divisionTwoNumber(56,10));
        assertEquals(6,calculator.divisionTwoNumber(20,3));
    }

}
