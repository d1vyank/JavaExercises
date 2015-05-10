import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for solving aquare roots
 */
public class SquareRootTests {
	private Calculator calc;
    @Before public void setUp() throws Exception {
    	calc = new Calculator();
    }

    @After public void tearDown() throws Exception {
    }

    @Test public void testRandomPositiveSquareRoot() {
        // You cannot use the Math.sqrt() function in the test!
    	double x = 4.0;
    	assertEquals(calc.getSquareRoots(x), Double.valueOf(2.0));
        
    }

    @Test public void testRandomNegitiveSquareRoot() {
        // The result should be a complex number i.e. Double.isNaN()
    	double x = -2.0;
    	assertTrue(calc.getSquareRoots(x).isNaN());
    }

    @Test public void testSquareRootofZero() {
        // You cannot use the Math.sqrt() function in the test!
    	double x = 0.0;
    	assertEquals(calc.getSquareRoots(x), Double.valueOf(0.0));
    }

    @Test public void testSquareRootofOne() {
        // You cannot use the Math.sqrt() function in the test!
    	double x = 1.0;
    	assertEquals(calc.getSquareRoots(x), Double.valueOf(1.0));
    }

}
