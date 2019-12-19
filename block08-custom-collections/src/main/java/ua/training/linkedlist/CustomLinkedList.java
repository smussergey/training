package ua.training.linkedlist;

public interface CustomLinkedList<E> extends Iterable<E>, DescendingIterator<E> {
    void addLast(E e);

    void addFirst(E e);

    int size();

    E getElementByIndex(int counter);
}
