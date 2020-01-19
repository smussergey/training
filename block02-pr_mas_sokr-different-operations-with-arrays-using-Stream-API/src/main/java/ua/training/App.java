package ua.training;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class App {
    private static int[] generateTestData() {
        int[] elements = {4, 5, -6, 4, 5, 3, 4, -7, 1, 2, 4, 5, 7, 15};
        //return Arrays.copyOf(elements,elements.length);
        return elements;
    }

    public static void main(String[] args) {
        getCountOfElementsEquelToTarget(generateTestData(), 5);
        getAverageValueOfAllElement(generateTestData());
        getMinElementValueAndIndex(generateTestData());
        getMaxElementValueAndIndex(generateTestData());
        getSumOfArrayElements(generateTestData());


    }

    //5
    public static void getCountOfElementsEquelToTarget(int[] elements, int targetElement) {
        System.out.println("5. getCountOfElementsEquelToTarget: " + targetElement);
        printlArray(elements);
        Arrays.stream(elements)
                .mapToObj(Long::valueOf)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .filter(el -> el.getKey() == targetElement)
                .findAny()
                .ifPresent(entry -> System.out.println("targetElement: " + entry.getKey() + " appears : " + entry.getValue() + " times"));
    }

    //4.
    public static void getAverageValueOfAllElement(int[] elements) {
        System.out.println("4. getAverageValueOfAllElement: " + Arrays.stream(elements)
                .summaryStatistics()
                .getAverage());

    }


    //3.
    public static void getMinElementValueAndIndex(int[] elements) {
        System.out.println("3. getMinElementValueAndIndex:");
        printlArray(elements);

        IntStream.range(0, elements.length)
                .reduce((IndexAccumulator, indexOfNextElement) ->
                        elements[IndexAccumulator] < elements[indexOfNextElement]
                                ? IndexAccumulator : indexOfNextElement)
                .ifPresent(index -> System.out.println("value= " + elements[index] + "   index= " + index));
    }


    //2.
    public static void getMaxElementValueAndIndex(int[] elements) {
        System.out.println("2. getMaxElementValueAndIndex:");
        printlArray(elements);

        IntStream.range(0, elements.length)
                .reduce((IndexAccumulator, indexOfNextElement) ->
                        elements[IndexAccumulator] > elements[indexOfNextElement]
                                ? IndexAccumulator : indexOfNextElement)
                .ifPresent(index -> System.out.println("value= " + elements[index] + "   index= " + index));
    }

    //1.
    public static void getSumOfArrayElements(int[] elements) {
        Arrays.stream(elements)
                .reduce((accumulator, el) -> {
//                    System.out.print("element = " + el);
//                    System.out.println(" acam = " + accumulator);
                    return el + accumulator;
                })
                .ifPresent(sum -> System.out.println("1. getSumOfArrayElements = " + sum));

    }


    private static void printlArray(int[] elements) {
        String result = Arrays.stream(elements)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("  "));
        System.out.println(result);
    }
}
