package com.day06_annotation_and_reflection.annotation;

// Legacy API class with an old deprecated method and a new method
class LegacyAPI {

    // Marking the method as deprecated to indicate it should not be used
    @Deprecated
    public void oldFeature() {
        System.out.println("⚠️ Warning: oldFeature() is deprecated. Use newFeature() instead.");
    }

    // New recommended method
    public void newFeature() {
        System.out.println("✅ newFeature() is the recommended method to use.");
    }
}

// Main class to test the usage of both methods
public class Deprecat {
    public static void main(String[] args) {

        // Creating an object of LegacyAPI
        LegacyAPI api = new LegacyAPI();

        // Calling the old deprecated method
        api.oldFeature();

        // Calling the new recommended method
        api.newFeature();
    }
}
