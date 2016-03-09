import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: KDE
 * Date: 09.03.16
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest {
    public Calculator calculator;
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() throws Exception {
        Assert.assertEquals(calculator.addition(1,1), 2);
    }


    @Test
    public void testSubsctraction() throws Exception {
        Assert.assertEquals(calculator.subsctraction(2, 1), 1);
    }

    @Test
    public void testMultiplication() throws Exception {
        Assert.assertEquals(calculator.multiplication(2, 2), 4);
    }

    @Test
    public void testDivision() throws Exception {
        Assert.assertEquals(calculator.division(4, 2), 2.0f);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDivisionNegative() throws Exception {
        calculator.division(4, 0);
    }

    @Test
    public void testRoot() throws Exception {
        Assert.assertEquals(calculator.root(4), 2.0d);
    }

    @Test
    public void testPower() throws Exception {
        Assert.assertEquals(calculator.power(2, 2), 4.0d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPowerNegative() throws Exception {
        calculator.power(2, 0);
    }

    @Test
    public void testFibonacci() {
        Assert.assertEquals(calculator.fibonacci(5), 13);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFibonacciNegative() {
        Assert.assertEquals(calculator.fibonacci(-5), 13);
    }
}

