package ua.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestModel {

    private static Model model;

    @BeforeClass
    public static void initModel() {
        model = new Model();
    }

    @Test
    public void testSecretNumber_isInRangeOfPrimaryMinBarrierAndPrimaryMaxBarrierExclusively() {
        for (int i = 0; i <= 1000; i++) {
            model.setMinBarrier(GlobalConstants.PRIMARY_MIN_BARRIER);
            model.setMaxBarrier(GlobalConstants.PRIMARY_MAX_BARRIER);
            model.setSecretNumber();

            int secretNumber = model.getSecretNumber();
            System.out.println(secretNumber);
            Assert.assertTrue(secretNumber > GlobalConstants.PRIMARY_MIN_BARRIER
                    && secretNumber < GlobalConstants.PRIMARY_MAX_BARRIER);
        }
    }
}

