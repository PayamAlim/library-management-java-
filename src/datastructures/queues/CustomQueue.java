package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomQueue() {
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
        T removedData = list.getFirst();
        list.removeFirst();
        return removedData;
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;
        T removedData = list.getFirst();
        list.removeFirst();
        return removedData;
    }

    @Override
    public T element() {
        if (isEmpty())
            throw new NoSuchElementException("Nothing to show!");
        return list.getFirst();
    }

    @Override
    public T peek() {
        return isEmpty()? null: list.getFirst();
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