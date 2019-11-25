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
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setSecretNumber();

        Scanner scanner = new Scanner(System.in);
    }
}
