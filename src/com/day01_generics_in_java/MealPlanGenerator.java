package com.day01_generics_in_java;


import java.util.*;

// MealPlan interface
interface MealPlan { String getMealType(); }

// Specific meal types
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
}
class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
}

// Generic Meal class restricted to MealPlan
class Meal<T extends MealPlan> {
    T type;
    Meal(T type) {
        this.type = type;
    }
    void show() {
        System.out.println("Meal Plan: " + type.getMealType());
    }
}

// Generic method to validate and generate a meal plan
class MealGenerator {
    static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {

        System.out.println("Generated: " + meal.type.getMealType() + " Meal Plan");
    }
}

// Example usage
public class MealPlanGenerator {
    public static void main(String[] args) {

        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());

        veganMeal.show();

        MealGenerator.generateMealPlan(veganMeal);
    }
}
