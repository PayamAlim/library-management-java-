package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);

        newNode.next = head;
        head.prev = newNode;

        head = newNode;
    }

    @Override
    public void addLast(T t) {
        Node<T> newNode = new Node<>(t);

        if (head == null) {
            tail = head = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("No element to remove!");

        T removedData = head.data;

        head = head.next;
        head.prev = null;

        return removedData;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("No element to remove!");

        T removedData = tail.data;

        tail = tail.prev;
        tail.next = null;

        return removedData;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index!");

        Node<T> current = head;
        for (int i = 0; i < index; i ++)
            current = current.next;
        return current.data;
    }

    @Override
    public T set(int index, T element) {
        if (element == null) throw new NullPointerException("Cannot add null value!");
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index!");

        Node<T> current = head;
        for (int i = 0; i < index; i ++)
            current = current.next;
        return current.data = element;
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

        Node<T> newNode = new Node<>(t);

        newNode.prev = tail;
        tail.next = newNode;

        tail = newNode;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(o))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}