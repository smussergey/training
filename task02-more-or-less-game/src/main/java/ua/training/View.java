package ua.training;

public class View {

    // Text's constants

    public static final String GUESS_NUMBER = "Try to guess the integer number from range: ";
    public static final String INCORRECT_INPUT_DATA = "Wrong input! Please, enter integer number";
    public static final String OUT_OF_RANGE_NUMBER = "You have entered the number out of the range";
    public static final String TOO_BIG_NUMBER = "Please enter smaller number";
    public static final String TOO_SMALL_NUMBER = "Please enter bigger number";
    public static final String CONGRATULATION = "You have guessed the number in attempts =  ";

    public void printMessageToGuessNumberFromRange(int min, int max) {
        System.out.println(GUESS_NUMBER + min + " to " + max);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
