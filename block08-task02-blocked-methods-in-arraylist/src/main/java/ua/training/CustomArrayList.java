package ua.training;

import com.sun.istack.internal.NotNull;

import java.util.Iterator;

public interface CustomArrayList<E> {
    boolean add(E e);

    E get(int index);

    int size();
}

