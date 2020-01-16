package ua.training;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    private static int[] generateTestData() {
        int[] elements = {4, 5, -6, 4, 5, 3, 4, -7, 1, 2, 4, 5, 7, 15};
        //return Arrays.copyOf(elements,elements.length);
        return elements;
    }

    public static void main(String[] args) {
        getMaxElementValueAndIndex(generateTestData());
        getSumOfArrayElements(generateTestData());
    }

    //2.
    public static void getMaxElementValueAndIndex(int[] elements) {
        printlArray(elements);
        System.out.println("//2. getMaxElementValueAndIndexElements:");

        IntStream.range(0, elements.length)
                .reduce((IndexAccumulator, indexOfNextElement) ->
                        elements[IndexAccumulator] > elements[indexOfNextElement]
                                ? IndexAccumulator : indexOfNextElement)
                .ifPresent(index -> System.out.println("value= " + elements[index] + "index= " + index));
    }

    //1.
    public static void getSumOfArrayElements(int[] elements) {
        Arrays.stream(elements)
                .reduce((accumulator, el) -> {
                    System.out.print("element = " + el);
                    System.out.println(" acam = " + accumulator);
                    return el + accumulator;
                })
                .ifPresent(sum -> System.out.println("//1. getSumOfArrayElements = " + sum));

    }


    private static void printlArray(int[] elements) {
        String result = Arrays.stream(elements)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("  "));
        System.out.println(result);
    }
}
