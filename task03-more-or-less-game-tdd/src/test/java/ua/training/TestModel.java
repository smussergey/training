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
            model.setPrimaryBarriers(GlobalConstants.PRIMARY_MIN_BARRIER,
                    GlobalConstants.PRIMARY_MAX_BARRIER);

            model.initializeSecretValue();

            int secretNumber = model.getSecretValue();

            Assert.assertTrue(secretNumber > GlobalConstants.PRIMARY_MIN_BARRIER
                    && secretNumber < GlobalConstants.PRIMARY_MAX_BARRIER);
        }
    }

    @Test
    public void testIsSecretNumberGuessed() {
        model.setSecretValue(50);
        int secretValue = model.getSecretValue();
        Assert.assertTrue(model.isSecretNumberGuessed(secretValue));
    }

    @Test
    public void testNewMinBarrierIsSet_IfInputValueIsNotGuessed() {
        model.setSecretValue(50);
        int inputValue = 40;
        int secretValue = model.getSecretValue();

        System.out.println("secretValue = " + secretValue + " inputValue = " + inputValue);
        model.isSecretNumberGuessed(inputValue);

        Assert.assertTrue(model.getMinBarrier() == inputValue);


    }

    @Test
    public void testNewMaxBarrierIsSet_IfInputValueIsNotGuessed() {
        model.setSecretValue(50);
        int inputValue = 60;
        int secretValue = model.getSecretValue();

        System.out.println("secretValue = " + secretValue + " inputValue = " + inputValue);
        model.isSecretNumberGuessed(inputValue);

        Assert.assertTrue(model.getMaxBarrier() == inputValue);
    }

}

