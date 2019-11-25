package ua.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestModel {

    private static Model model;

    @BeforeClass
    public static void initModel() {
        model = new Model();
    }

    @Ignore
    @Test
    public void testSecretNumber_isInRangeOfPrimaryMinBarrierAndPrimaryMaxBarrierExclusively() {
        for (int i = 0; i <= 10000; i++) {
            model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                                    GlobalConstants.PRIMARY_MAX_BARRIER);

            model.setSecretNumber();

            int secretNumber = model.getSecretNumber();

            Assert.assertTrue(secretNumber > GlobalConstants.PRIMARY_MIN_BARRIER
                    && secretNumber < GlobalConstants.PRIMARY_MAX_BARRIER);
        }
    }
}

