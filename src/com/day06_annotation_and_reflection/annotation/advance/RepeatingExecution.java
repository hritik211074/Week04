package com.day06_annotation_and_reflection.annotation.advance;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// Define @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)

@interface CacheResult {}

// Class with a computationally expensive method
class Calculator {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveCalculation(int num) {

        if (cache.containsKey(num)) {
            System.out.println("Returning cached result for " + num);
            return cache.get(num);
        }
        System.out.println("Computing result for " + num);

        int result = num * num; // Simulating a heavy computation
        cache.put(num, result);
        return result;
    }
}

// Test class
public class RepeatingExecution {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        System.out.println(calc.expensiveCalculation(5)); // Computes and stores

        System.out.println(calc.expensiveCalculation(5)); // Fetches from cache

        System.out.println(calc.expensiveCalculation(10)); // Computes and stores
    }
}

