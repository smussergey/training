package ua.training;

import java.util.concurrent.ThreadLocalRandom;

public class Model {
    private final int LEFT_BOUNDARY_DEFAULTE = 0;
    private final int RIGHT_BOUNDARY_DEFAULTE = 100;
    private final int BOUNDARY_CORRECTION = 1;
    private final int targetNumber = ThreadLocalRandom.current().nextInt(100 + BOUNDARY_CORRECTION);
    private int attemptCounter = 0;

    public boolean isGuessedNumberInTargetRange(int guessedNumber) {
        return guessedNumber >= LEFT_BOUNDARY_DEFAULTE && guessedNumber <= RIGHT_BOUNDARY_DEFAULTE;
    }

    public boolean isGuessedNumberBiggerThanTargetNumber(int guessedNumber) {
        return guessedNumber > targetNumber;
    }

    public boolean isGuessedNumberSmallerThanTargetNumber(int guessedNumber) {
        return guessedNumber < targetNumber;
    }

    public void incrementAttemptCounter() {
        attemptCounter++;
    }

    public int getLEFT_BOUNDARY_DEFAULTE() {
        return LEFT_BOUNDARY_DEFAULTE;
    }

    public int getRIGHT_BOUNDARY_DEFAULTE() {
        return RIGHT_BOUNDARY_DEFAULTE;
    }

    public int getAttemptCounter() {
        return attemptCounter;
    }
}