package ua.training;

public class Model {

    private int minBarrier;
    private int maxBarrier;
    private int secretNumber;


    public void setPrimaryBarrier(int minBarrier, int maxBarrier){
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public void setSecretNumber() {
        secretNumber = (int) Math.ceil(Math.random() * (maxBarrier - minBarrier - 1) + minBarrier);
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public int getSecretNumber() {
        return secretNumber;
    }



}
