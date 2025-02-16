package com.day06_annotation_and_reflection.annotation;

// Parent class Animal
class Animal {
    // Method to be overridden by subclasses
    public void makeSound() {
        System.out.println("🐾 The animal makes a sound.");
    }
}

// Child class Dog that overrides the makeSound() method
class Dog extends Animal {

    // Using @Override to indicate that we are overriding the parent method
    @Override
    public void makeSound() {
        System.out.println("The dog barks: Woof! Woof!");
    }
}

// Main class to test the overriding
public class OverrideExample {
    public static void main(String[] args) {
        // Creating an instance of Dog
        Dog myDog = new Dog();

        // Calling the overridden method
        myDog.makeSound();  // It should print "🐶 The dog barks: Woof! Woof!"
    }
}
