package ua.training.hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CustomHashSet<E> {
    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public CustomHashSet() {
        map = new HashMap<>();
    }

    public CustomHashSet(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor);
    }


    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    public void clear() {
        map.clear();
    }

}
