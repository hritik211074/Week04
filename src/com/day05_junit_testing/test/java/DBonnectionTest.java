package com.day05_junit_testing.test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class DBConnectionTest {
    private DBConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DBConnection();  // Create a new DBConnection instance before each test
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();  // Ensure the connection is closed after each test
    }

    @Test
    void testConnectionEstablished() {
        dbConnection.connect();
        assertTrue(dbConnection.isConnected(), "Database should be connected");
    }

    @Test
    void testConnectionClosed() {
        dbConnection.connect();
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database should be disconnected");
    }

    @Test
    void testInitialState() {
        assertFalse(dbConnection.isConnected(), "Database should be disconnected initially");
    }
}
