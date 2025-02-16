package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

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

    public boolean isConnected() {
        return isConnected;
    }
}

