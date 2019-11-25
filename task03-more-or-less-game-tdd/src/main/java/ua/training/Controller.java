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
                        String.valueOf(model.getAttempts().size())));
                break;
            }
        }
    }

    private int inputValueWithScanner(Scanner scanner) {
        int inputValue;
        view.printMessage(getInputIntMessage());


        while (true) {
            while (!scanner.hasNextInt()) {
                view.printMessage(View.INCORRECT_INPUT_DATA + getInputIntMessage());
                scanner.next();
            }
            inputValue = scanner.nextInt();
            if (inputValue > model.getMinBarrier() && inputValue < model.getMaxBarrier()) {
                return inputValue;

            } else {
                view.printMessage(View.INCORRECT_INPUT_DATA + getInputIntMessage());
                scanner.next();
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
