package ua.training.linkedlist;

import java.util.Iterator;

public class CustomLinkedListApp {
    public static void main(String[] args) {
        CustomLinkedList<String> str = new CustomLinkedListImpl<>();

        str.addLast("firstLast");
        str.addLast("secondLast");
        str.addLast("thirdLast");
        str.addLast("forthLast");

        for (String v : str) {
            System.out.println(v);
        }
        System.out.println("size = " + str.size());
        System.out.println();

        System.out.println("get by index = " + str.getElementByIndex(0));
        System.out.println();

        str.addFirst("firstFirst");
        str.addFirst("firstFirstFirst");

        for (String v : str) {
            System.out.println(v);
        }
        System.out.println("size = " + str.size());
        System.out.println();

        System.out.println("get by index = " + str.getElementByIndex(1));
        System.out.println();


        System.out.println("DescendingIterator:");
        Iterator iterator = str.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
