package ua.training;

public class View {

    public static final String INPUT_INT_DATA = "Input integer number from the range exclusively: ";
    public static final String INCORRECT_INPUT_DATA = "Wrong input!";
    public static final String SPACE_SING = " ";
    public static final String HYPHEN_SING = "-";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatenateStrings(String... messages) {
        StringBuilder concatString = new StringBuilder();
        for (String v : messages) {
            concatString = concatString.append(v);
        }
        return concatString.toString();
    }
}