package ua.training;

import ua.training.util.DataGenerator;

import java.util.HashMap;
import java.util.Map;

public class StreamIntegersApp {

    public static void main(String[] args) {
        StreamOfIntegers streamOfIntegers = new StreamOfIntegers();

        System.out.println("Initial data: ");
        DataGenerator.getIntegersNumbers()
                .stream()
                .forEach(a -> System.out.print(a + " ,"));
        System.out.println();

        System.out.println("Average value = " + streamOfIntegers.getAverageValue(DataGenerator.getIntegersNumbers()));

        Map<Integer, Integer> result = new HashMap<>();
        result = streamOfIntegers.getMinElementAntItsIndex(DataGenerator.getIntegersNumbers());
        int value = result.values().stream().findFirst().get();
        int index = result.keySet().stream().findFirst().get();
        System.out.println("Index of min element = " + index + " value = " + value);

        System.out.println("Number of elements equals 0 = " + streamOfIntegers.getNumberOfElementsEqualsZero(DataGenerator.getIntegersNumbers()));

        System.out.println("Number of elements more than 0 = " + streamOfIntegers.getNumberOfElementsLargerThanZero(DataGenerator.getIntegersNumbers()));

        System.out.println("Multiplied by value = " + streamOfIntegers.multiplyAllElementByNumber(DataGenerator.getIntegersNumbers(), 10));

    }

}
