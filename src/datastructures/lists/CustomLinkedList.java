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

        size ++;
    }

    @Override
    public void addLast(T t) {
        Node<T> newNode = new Node<>(t);
        size ++;

        if (head == null) {
            head = newNode;
            tail = newNode;
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
        if (head != null)
            head.prev = null;

        size --;

        return removedData;
    }

    @Override
    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("No element to remove!");

        T removedData = tail.data;

        tail = tail.prev;
        tail.next = null;

        size --;

        return removedData;
    }

    @Override
    public T getFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Linked list is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty())
            throw new NoSuchElementException("Linked list is empty");
        return tail.data;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
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

        size ++;
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

                size --;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}