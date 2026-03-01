
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerOn() {
        System.out.println("@BeforeAll Power ON (before the first test)");
        calculator.powerOn();
    }

    @AfterAll
    public static void testPowerOff() {
        System.out.println("@AfterAll Power OFF (all tests executed).");
        calculator.powerOff();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        System.out.println("  Reset calculator.");
        calculator.reset();
        assertEquals(0, calculator.getResult(), "Reset failed");
    }

    @ParameterizedTest(name = "The square of {0} is {1}")
    @CsvSource({ "2, 4", "4, 16", "5, 25", "4, 16", "5, 25" })
    public void testSquare(int n, int expected) {
        calculator.square(n);
        assertEquals(expected, calculator.getResult(), "Squaring number {} is incorrect");
    }



    @ParameterizedTest(name = "The square root of {0} is {1}")
    @CsvSource({ "2, 1", "-16, 0" })
    public void testSquareRoot2(int n, int expected) {
        calculator.squareRoot(n);
        assertEquals(expected,calculator.getResult(),"Square root of {}");
        // Add assertXXX() here, expected result should be (int) Math.sqrt(2)
    }

//    @Test
//    @DisplayName("Test negative square root")
//    public void testSquareRootNegative() {
////        fail("TEST HAS NOT BEEN IMPLEMENTED YET.");
//        calculator.squareRoot(-2);
//        assertEquals(0,calculator.getResult());
//    }
}
