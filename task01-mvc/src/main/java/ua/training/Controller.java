package ua.training;

import java.util.Scanner;

public class Controller {
    // The Regex
    public static final String REGEX_HELLO = "Hello";
    public static final String REGEX_JAVA = "Java!";


    // Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        Scanner scanner = new Scanner(System.in);

        model.setFirstWord(inputValueWithScanner(scanner, View.INPUT_DATA_FIRST, REGEX_HELLO));
        model.setSecondWord(inputValueWithScanner(scanner, View.INPUT_DATA_SECOND, REGEX_JAVA));

        view.printMessageAndResult(View.RESULT_MESSAGE, model.getResult());
    }

    // The Utility methods
    public String inputValueWithScanner(Scanner sc, String message, String regex) {
        view.printMessage(message);
        while ( ! sc.hasNext(regex)) {
            view.printMessage(View.WRONG_INPUT_DATA + message);
            sc.next();
        }
        return sc.next();
    }
}

