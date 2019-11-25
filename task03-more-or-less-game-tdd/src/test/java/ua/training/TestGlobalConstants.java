package ua.training;

import org.junit.Assert;
import org.junit.Test;

public class TestGlobalConstants {

    @Test
    public void testPrimaryMinBarrier_equals_0() {
        Assert.assertEquals(0, GlobalConstants.PRIMARY_MIN_BARRIER);
    }

    @Test
    public void testPrimaryMaxBarrier_equals_0() {
        Assert.assertEquals(100, GlobalConstants.PRIMARY_MAX_BARRIER);
    }
}

