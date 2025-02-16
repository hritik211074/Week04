package com.day06_annotation_and_reflection.annotation.advance;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// Define @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// User class with annotated fields
class UserName {

    @JsonField(name = "user_name") String username;
    @JsonField(name = "user_age") int age;

    public UserName(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

// Convert object to JSON string
class JsonSerializer {
    static String toJson(Object obj) throws Exception {

        Map<String, String> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                jsonMap.put(field.getAnnotation(JsonField.class).name(), field.get(obj).toString());
            }
        }
        return jsonMap.toString().replace("=", ": ");
    }
}

// Test JSON serialization
public class JSONSerialization {

    public static void main(String[] args) throws Exception {

        System.out.println(JsonSerializer.toJson(new UserName("suresh", 25)));
    }
}
