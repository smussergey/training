package ua.training;

public class Model {

    private int minBarrier;
    private int maxBarrier;
    private int secretNumber;

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

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber() {
        secretNumber = (int) Math.ceil(Math.random() * (maxBarrier - minBarrier - 1) + minBarrier);
    }

}
