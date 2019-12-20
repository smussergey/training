package ua.training.treeset;

import java.util.List;

public interface CustomTreeSet<E> extends Iterable {
    boolean add(E e);

    List<E> get();

    int size();

    CustomTreeSetImpl.Leaf find(E e);
}
