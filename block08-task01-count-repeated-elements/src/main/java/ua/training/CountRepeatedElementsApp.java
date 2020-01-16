package ua.training;

import java.util.*;
import java.util.function.Function;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountRepeatedElementsApp {
    public static void main(String[] args) {
        int[] el = {4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7};
        List<Integer> elements = Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7);

        elements.stream().
                collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + "-" + entry.getValue()));
    }
}
