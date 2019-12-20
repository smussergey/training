package ua.training;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomArrayListImpl<E> implements CustomArrayList<E> {
    private final ArrayList<E> arrayList;

    public CustomArrayListImpl() {
        arrayList = new ArrayList<>();
    }

    @Override
    public boolean add(E e) {
        return arrayList.add(e);
    }

    @Override
    public E get(int index) {
        return arrayList.get(index);
    }

    @Override
    public int size() {
        return arrayList.size();
    }
}

