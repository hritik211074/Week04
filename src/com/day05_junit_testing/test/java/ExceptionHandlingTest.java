package com.day05_junit_testing.test.java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class ExceptionHandlingTest {
    private ExceptionHandling exceptionHandling;

    @BeforeEach
    void setUp() {
        exceptionHandling = new ExceptionHandling();
    }

    @Test

    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> exceptionHandling.divide(10, 0));
    }

    @Test
    void testDivideValid() {
        assertEquals(5, exceptionHandling.divide(10, 2));
    }
}