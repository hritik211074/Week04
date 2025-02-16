
package com.day05_junit_testing.test.java;
import org.example.TemperatureConverter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.01);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.01);
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40), 0.01);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.01);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.01);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40), 0.01);
    }
}
