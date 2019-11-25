package ua.training;

public class View {

    public static final String INPUT_INT_DATA = "Input integer number from the range exclusively: ";
    public static final String INCORRECT_INPUT_DATA = "Wrong input!\n";
    public static final String HYPHEN_SING = "-";
    public static final String SPACE_SING = " ";
    public static final String CONGRATULATION = "Congratulation! You have guessed the secret value.";
    public static final String SECRET_VAlUE = "\nSecret value = ";
    public static final String NUMBER_OF_ATTEMPTS = "\nNumber of attempts =  ";
    public static final String ATTEMPTS_VALUES = "\nAttempts values: ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatenateStrings(String... messages) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String v : messages) {
            stringBuilder = stringBuilder.append(v);
        }
        return stringBuilder.toString();
    }
}