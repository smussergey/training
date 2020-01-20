package ua.training;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StreamsApp {
    private static int[] generateTestData() {
        int[] elements = {4, 5, -6, 4, 5, 0, 3, 4, -7, 1, 2, 4, 5, 7, 0, 15};
        //return Arrays.copyOf(elements,elements.length);
        return elements;
    }

    public static void main(String[] args) {
        multiplyArrayElementsByNumber(generateTestData(), 10);
        getCountOfElementsGreaterThanZero(generateTestData());
        getCountOfElementsEquelsToZero(generateTestData());
        getCountOfElementsEquelToTarget(generateTestData(), 5);
        getAverageValueOfAllElement(generateTestData());
        getMinElementValueAndIndex(generateTestData());
        getMaxElementValueAndIndex(generateTestData());
        getSumOfArrayElements(generateTestData());


    }

    private static void multiplyArrayElementsByNumber(int[] elements, int multiplier) {
        System.out.println("     8. multiplyArrayElementsByNumber: ");
        printlArray(elements);
        Arrays.stream(elements)
                .mapToLong(el -> el * multiplier)
                .forEach(System.out::print);
        System.out.println();
    }

    //7
    public static void getCountOfElementsGreaterThanZero(int[] elements) {
        System.out.println("     7. getCountOfElementsGreaterThanZero: ");
        printlArray(elements);
        long result;
        result = Arrays.stream(elements)
                .filter(el -> el > 0)
                .count();
        System.out.println("Elements greater than 0  appears : " + result + " times");
    }

    //6
    public static void getCountOfElementsEquelsToZero(int[] elements) {
        System.out.println("     6. getCountOfElementsEquelsToZero: " + 0);
        printlArray(elements);
        Arrays.stream(elements)
                .mapToObj(Long::valueOf)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .filter(el -> el.getKey() == 0)
                .findAny()
                .ifPresent(entry -> System.out.println("Element: " + entry.getKey() + " appears : " + entry.getValue() + " times"));
    }


    //5
    public static void getCountOfElementsEquelToTarget(int[] elements, int targetElement) {
        System.out.println("     5. getCountOfElementsEquelToTarget: " + targetElement);
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
        System.out.println("     4. getAverageValueOfAllElement: " + Arrays.stream(elements)
                .summaryStatistics()
                .getAverage());

    }


    //3.
    public static void getMinElementValueAndIndex(int[] elements) {
        System.out.println("     3. getMinElementValueAndIndex:");
        printlArray(elements);

        IntStream.range(0, elements.length)
                .reduce((IndexAccumulator, indexOfNextElement) ->
                        elements[IndexAccumulator] < elements[indexOfNextElement]
                                ? IndexAccumulator : indexOfNextElement)
                .ifPresent(index -> System.out.println("value= " + elements[index] + "   index= " + index));
    }


    //2.
    public static void getMaxElementValueAndIndex(int[] elements) {
        System.out.println("     2. getMaxElementValueAndIndex:");
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
                .ifPresent(sum -> System.out.println("     1. getSumOfArrayElements = " + sum));

    }


    private static void printlArray(int[] elements) {
        String result = Arrays.stream(elements)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("  "));
        System.out.println(result);
    }
}
