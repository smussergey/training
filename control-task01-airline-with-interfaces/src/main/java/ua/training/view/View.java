package ua.training.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    public static String LOCALE_LANGUAGE_UA = "ua";
    public static String LOCALE_LANGUAGE_EN = "en";

    // Resource Bundle Installation's
    private static String MESSAGES_BUNDLE_NAME = "messages";
    private static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
//                    new Locale(LOCALE_LANGUAGE_UA, "UA"), new UTF8Control());  // Ukrainian
                    new Locale(LOCALE_LANGUAGE_EN));        // English

    public void printMessages(String... messages) {
        for (String message : messages) {
            System.out.print(message);
        }
        System.out.print("\n");
    }

    public String concatenateStrings(String... messages) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String v : messages) {
            stringBuilder = stringBuilder.append(v);
        }
        return stringBuilder.toString();
    }

    public String getBundleString(String message) {
        return bundle.getString(message);
    }

    public static ResourceBundle getBundle() {
        return bundle;
    }
}
