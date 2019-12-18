package ua.training.util;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    private static int[] intNumbers = {1, 5, 2, 0, -1, 3, 0, 4, 3, 5};

    public static int[] getIntNumbers() {
        return intNumbers;
    }

    public static List<Integer> getIntegersNumbers() {
        List<Integer> integerNumbers = new ArrayList<>();
        for (int i = 0; i < intNumbers.length; i++) {
            integerNumbers.add(intNumbers[i]);
        }
        return integerNumbers;
    }
}
