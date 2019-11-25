package ua.training;

public class View {

    // Text's constants
    public static final String INPUT_DATA_FIRST = "Enter first word \"Hello\", then press button \"Enter\": ";
    public static final String INPUT_DATA_SECOND = "Enter second word \"Java!\", then press button \"Enter\": ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please!\n";
    public static final String RESULT_MESSAGE = "You have entered: ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageAndResult(String message, String result) {
        System.out.println(message + result);
    }
}
