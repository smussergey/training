package ua.training;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        model.setPrimaryBarriers(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.initializeSecretValue();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (model.isSecretNumberGuessed(inputValueWithScanner(scanner))) {
                view.printMessage(view.concatenateStrings(View.CONGRATULATION,
                        View.SECRET_VAlUE,
                        String.valueOf(model.getSecretValue()),
                        View.SPACE_SING,
                        View.NUMBER_OF_ATTEMPTS,
                        String.valueOf(model.getAttempts().size()),
                        View.SPACE_SING,
                        View.ATTEMPTS_VALUES,
                        String.valueOf(model.getAttempts())));
                break;
            }
        }
    }

    private int inputValueWithScanner(Scanner scanner) {
        int inputIntValue;
        view.printMessage(getInputIntMessage());

        while (true) {
            while (!scanner.hasNextInt()) {
                view.printMessage(View.INCORRECT_INPUT_DATA + getInputIntMessage());
                scanner.next();
            }

            inputIntValue = scanner.nextInt();

            if (inputIntValue > model.getMinBarrier() && inputIntValue < model.getMaxBarrier()) {
                return inputIntValue;

            } else {
                view.printMessage(View.INCORRECT_INPUT_DATA + getInputIntMessage());
            }
        }
    }

    private String getInputIntMessage() {
        return view.concatenateStrings(View.INPUT_INT_DATA,
                String.valueOf(model.getMinBarrier()),
                View.HYPHEN_SING,
                String.valueOf(model.getMaxBarrier()));
    }
}
