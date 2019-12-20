package ua.training.treeset;

public class CustomTreeSetApp {
    public static void main(String[] args) {
        CustomTreeSet<Integer> customTreeSet = new CustomTreeSetImpl<>();
        customTreeSet.add(1);
        customTreeSet.add(5);
        customTreeSet.add(2);
        customTreeSet.add(-7);
        customTreeSet.add(10);
        customTreeSet.add(3);

        customTreeSet.get()
                .stream()
                .forEach(System.out::println);

        System.out.println("size=" + customTreeSet.size());

    }
}
