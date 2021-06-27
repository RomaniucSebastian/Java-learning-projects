 package TemaJUNIT;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculator() {
        Calculator calculator = new Calculator();

        int result = calculator.calculator("9 km + 10 m - 10 m - 9 km + 1 mm");
        assertEquals(1, result);
    }

    @Test
    public void testCalculator2() {
        Calculator calculator = new Calculator();

        int result = calculator.calculator("1 km + 2 mm - 1 dm - 10 cm + 28 mm");
        assertEquals(999830, result);
    }

    @Test
    public void testCalculatorNumarNegativ() {
        Calculator calculator = new Calculator();

        int result = calculator.calculator("1 km - 2 dm -  3 m - 4 cm - 5 mm");
        assertEquals(996755, result);
    }
}

