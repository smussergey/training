package ua.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import ua.training.calculation.Arithmetics;

public class TestArithmetics {
    private static Arithmetics arithmetics;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout timeout = new Timeout(1000);

    @BeforeClass
    public static void initArithmetics() {
        arithmetics = new Arithmetics();
    }

    @Test
    public void testAdd() {
        double res = arithmetics.add(3, 7);
        Assert.assertEquals(10.0, res, 0.0);
    }

    @Test
    public void testDeduct() {
        double res = arithmetics.deduct(3, 7);
        Assert.assertEquals(-4.0, res, 0.0);
    }

    @Test
    public void testMult() {
        double res = arithmetics.mult(3, 7);
        Assert.assertEquals(21.0, res, 0.0);
    }

    @Test
    public void testDiv() {
        double res = arithmetics.div(10, 5);
        Assert.assertEquals(2.0, res, 0.0);
    }

    @Test
    public void testDivException() {
        expectedException.expect(ArithmeticException.class);
        arithmetics.div(10.0, 0);
    }

    @Test(timeout = 1000)
    public void testTimeOut() {
        arithmetics.div(10.0, 2);
    }
}

