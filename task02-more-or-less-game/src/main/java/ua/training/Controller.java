package ua.training;

import java.util.Scanner;

public class Controller {
    private static final boolean CONTINUE_GAME = true;

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {

        Scanner scanner = new Scanner(System.in);
        view.printMessageToGuessNumberFromRange(model.getLEFT_BOUNDARY_DEFAULTE(), model.getRIGHT_BOUNDARY_DEFAULTE());

        while (CONTINUE_GAME) {
            int guessedNumber = inputValueWithScanner(scanner);
            model.incrementAttemptCounter();
            if (!model.isGuessedNumberInTargetRange(guessedNumber)) {
                view.printMessage(View.OUT_OF_RANGE_NUMBER);
                view.printMessageToGuessNumberFromRange(model.getLEFT_BOUNDARY_DEFAULTE(), model.getRIGHT_BOUNDARY_DEFAULTE());
                continue;
            }

            if (model.isGuessedNumberBiggerThanTargetNumber(guessedNumber)) {
                view.printMessage(View.TOO_BIG_NUMBER);
            } else if (model.isGuessedNumberSmallerThanTargetNumber(guessedNumber)) {
                view.printMessage(View.TOO_SMALL_NUMBER);
            } else {
                view.printMessage(View.CONGRATULATION + model.getAttemptCounter());
                break;
            }
        }
    }

    private int inputValueWithScanner(Scanner scanner) {
        while (CONTINUE_GAME) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                view.printMessage(View.INCORRECT_INPUT_DATA);
                scanner.next();
            }
        }
    }
}
