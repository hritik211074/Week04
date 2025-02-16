package com.day05_junit_testing.test.java;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import org.example.TaskProcessor;
import java.util.concurrent.TimeUnit;


public class TaskProcessorTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fail if it takes more than 2 seconds
    void testLongRunningTaskTimeout() {
        assertEquals("Task Completed", TaskProcessor.longRunningTask());
    }
}
