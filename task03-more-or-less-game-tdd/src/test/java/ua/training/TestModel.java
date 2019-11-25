package ua.training;

import org.junit.*;

public class TestModel {

    private Model model;

    @Before
    public void initModel() {
        model = new Model();
    }

    //@Ignore
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
    public void testNewMinBarrierIsSet_IfInputValueIsLessThanSecretValue() {
        int secretValue = 50;
        model.setSecretValue(secretValue);
        int inputValue = 40;
        model.isSecretNumberGuessed(inputValue);

        Assert.assertEquals(inputValue, model.getMinBarrier());
    }

    @Test
    public void testNewMaxBarrierIsSet_IfInputValueIsGreaterThanSecretValue () {
        int secretValue = 50;
        model.setSecretValue(secretValue);
        int inputValue = 60;
        model.isSecretNumberGuessed(inputValue);

        Assert.assertEquals(inputValue, model.getMaxBarrier());
    }

    @Test
    public void testCheckNumberOfAttemptsAreIncrementedByOne() {
        model.isSecretNumberGuessed(50);

        Assert.assertEquals(1, model.getAttempts().size());
    }
}

