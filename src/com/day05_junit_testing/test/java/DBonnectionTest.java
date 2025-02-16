
package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
class DBConnectionTest {
    private DBConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DBConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected(), "Database should be connected");
    }

    @Test
    void testConnectionClosed() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database should be disconnected");
    }
}
