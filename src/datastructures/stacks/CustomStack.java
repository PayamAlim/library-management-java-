package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomStack() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        try {
            list.addLast((T) t);
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("No memory!");
        }
    }

    @Override
    public boolean offer(Object t) {
        try {
            list.addLast((T) t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public T remove() {
        if (isEmpty()) throw new NoSuchElementException("Nothing to remove!");
        T removedData = list.getLast();
        list.removeLast();
        return removedData;
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;
        T removedData = list.getLast();
        list.removeLast();
        return removedData;
    }

    @Override
    public T element() {
        if (isEmpty())
            throw new NoSuchElementException("Nothing to show!");
        return list.getLast();
    }

    @Override
    public T peek() {
        return isEmpty()? null: list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}