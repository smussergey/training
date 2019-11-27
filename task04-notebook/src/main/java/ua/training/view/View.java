package ua.training.view;

public class View {

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
