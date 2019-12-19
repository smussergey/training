package ua.training;

import java.util.*;
import java.util.function.Function;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountRepeatedElementsApp {
    public static void main(String[] args) {
        int[] el = {4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7};
        List<Integer> elements = new ArrayList<>();
        elements.add(4);
        elements.add(5);
        elements.add(-6);
        elements.add(4);
        elements.add(5);
        elements.add(3);
        elements.add(4);
        elements.add(2);
        elements.add(4);
        elements.add(5);
        elements.add(7);

        Map<Integer, Long> repeatedElements = groupByValueAndCountOccurrence(elements);

        repeatedElements
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + "-" + entry.getValue()));
    }

    private static Map<Integer, Long> groupByValueAndCountOccurrence(List<Integer> el) {
        return el.stream()
                .collect(groupingBy(Function.identity(), counting()));
    }
}
