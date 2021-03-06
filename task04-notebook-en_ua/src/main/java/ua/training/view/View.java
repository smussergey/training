package ua.training.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua", "UA"), new UTF8Control());  // Ukrainian
//                    new Locale("en"));        // English

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWrongInputMessage(String inputMessage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = stringBuilder.
                append(bundle.getString(TextConstant.INCORRECT_INPUT_DATA))
                .append(inputMessage);
        System.out.println(stringBuilder.toString());
    }

    public String concatenateBundleStrings(String... messages) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String v : messages) {
            stringBuilder = stringBuilder.append(bundle.getString(v));
        }
        return stringBuilder.toString();
    }

}
