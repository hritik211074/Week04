package com.day05_junit_testing.main.java.org.example;

class DBConnection {
    private boolean isConnected;

    // Method to establish a connection
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    // Method to disconnect the connection
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    // Method to check if connected
    public boolean isConnected() {
        return isConnected;
    }
}
