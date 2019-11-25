package ua.training;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int minBarrier;
    private int maxBarrier;
    private int secretValue;
    private List<Integer> attempts = new ArrayList<>();

    public boolean isSecretNumberGuessed(int inputValue) {
        attempts.add(inputValue);
        if (secretValue == inputValue) {
            return true;
        } else {
            changeBarrier(inputValue);
            return false;
        }
    }

    private void changeBarrier(int inputValue) {
        if (inputValue < secretValue) {
            setMinBarrier(inputValue);
        } else setMaxBarrier(inputValue);

    }

    public void setPrimaryBarriers(int minBarrier, int maxBarrier) {
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public void initializeSecretValue() {
        secretValue = (int) Math.ceil(Math.random() * (maxBarrier - minBarrier - 1) + minBarrier);
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public void setMinBarrier(int minBarrier) {
        this.minBarrier = minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public void setMaxBarrier(int maxBarrier) {
        this.maxBarrier = maxBarrier;
    }

    public int getSecretValue() {
        return secretValue;
    }

    public void setSecretValue(int secretValue) {
        this.secretValue = secretValue;
    }

    public List<Integer> getAttempts() {
        return attempts;
    }

}
