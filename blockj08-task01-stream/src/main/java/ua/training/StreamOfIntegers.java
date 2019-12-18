package ua.training;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOfIntegers {

    public double getAverageValue(List<Integer> numbers) {
        return (double) (numbers.stream()
                .reduce(0, Integer::sum)) / numbers.size();
    }

    public Map<Integer, Integer> getMinElementAntItsIndex(List<Integer> numbers) {

        return numbers.stream()
                .sorted()
                .findFirst()
                .map(a -> {
                    Map<Integer, Integer> result = new HashMap<>();
                    result.put(numbers.indexOf(a), a);
                    return result;
                })
                .get();
    }

    public long getNumberOfElementsEqualsZero(List<Integer> numbers) {
        return numbers.stream()
                .filter(a -> a == 0)
                .count();
    }

    public long getNumberOfElementsLargerThanZero(List<Integer> numbers) {
        return numbers.stream()
                .filter(a -> a > 0)
                .count();
    }

    public List<Integer> multiplyAllElementByNumber(List<Integer> numbers, int multiplier) {
        return numbers.stream()
                .map(a -> a * multiplier)
                .collect(Collectors.toList());

    }


}
