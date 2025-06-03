package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index!");
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index!");
        return (T) (elements[index] = element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T t) {
        if (t == null) throw new NullPointerException("Cannot add null value!");

        ensureCapacity();
        elements[size] = t;
        size ++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i ++)
            if (elements[i].equals(o))
                return true;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) throw new NullPointerException("Cannot add null value!");

        boolean found = false;
        for (int i = 0; i < size; i ++) {
            if (found == true)
                elements[i - 1] = elements[i];
            if (elements[i].equals(o))
                found = true;
        }
        if (found) {
            size--;
            return true;
        }
        return false;
    }
}