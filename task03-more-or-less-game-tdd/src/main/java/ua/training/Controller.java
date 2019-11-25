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
    }

    private int inputValueWithScanner(Scanner scanner) {
        view.printMessage(getInputIntMessage());
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
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
