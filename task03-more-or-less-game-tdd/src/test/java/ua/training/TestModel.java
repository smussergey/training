package ua.training;

import org.junit.*;

public class TestModel {

    private static Model model;

    @Before
    public void initModel() {
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
        int secretValue = 50;
        model.setSecretValue(secretValue);
        Assert.assertTrue(model.isSecretNumberGuessed(secretValue));
    }

    @Test
    public void testNewMinBarrierIsSet_IfInputValueIsNotGuessed() {
        int secretValue = 50;
        model.setSecretValue(secretValue);

        int inputValue = 40;

        System.out.println("secretValue = " + secretValue + " inputValue = " + inputValue);
        model.isSecretNumberGuessed(inputValue);

        Assert.assertTrue(model.getMinBarrier() == inputValue);
    }

    @Test
    public void testNewMaxBarrierIsSet_IfInputValueIsNotGuessed() {
        int secretValue = 50;
        model.setSecretValue(secretValue);

        int inputValue = 60;

        System.out.println("secretValue = " + secretValue + " inputValue = " + inputValue);
        model.isSecretNumberGuessed(inputValue);

        Assert.assertTrue(model.getMaxBarrier() == inputValue);
    }

    @Test
    public void testCheckNumberOfAttemptsAreIncrementedByOne() {
        model.isSecretNumberGuessed(50);

        Assert.assertEquals(1, model.getAttempts().size());
    }
}

