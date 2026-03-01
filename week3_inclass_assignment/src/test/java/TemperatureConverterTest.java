import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(100.0,converter.fahrenheitToCelsius(212));
        assertEquals(60.0,converter.fahrenheitToCelsius(140));
        assertEquals(10.0,converter.fahrenheitToCelsius(50));
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(212.0,converter.celsiusToFahrenheit(100));
        assertEquals(122.0, converter.celsiusToFahrenheit(50));
        assertEquals(50.0, converter.celsiusToFahrenheit(10));
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(80));
        assertTrue(converter.isExtremeTemperature(-42));
        assertFalse(converter.isExtremeTemperature(0));
    }
}