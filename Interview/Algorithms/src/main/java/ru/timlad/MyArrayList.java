package ru.timlad;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList<E>{


    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private E[] array;

    public MyArrayList() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public void add(E value) {
        if (array.length == DEFAULT_CAPACITY) {
           extensionArray();
        }
        array[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(int index, E value) {

        if (array.length == DEFAULT_CAPACITY) {
            extensionArray();
        }

        E currentItem = value;

        for (int i = index ; i < array.length; i++) {
            E next = array[i];
            array[i] = currentItem;
            currentItem = next;
        }
        size++;

    }

    @Override
    public boolean delete(int index) {

        for (int i = index ; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;

        return true;
    }


    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    public void extensionArray() {
        E[] newArray = Arrays.copyOf(array, array.length + array.length/2 + 1);
        this.array = newArray;
    }

    private class MyArrayListIterator implements Iterator<E>{

        private final MyArrayList<E> list;

        private E current;
        private E next;

        private int index;



        public MyArrayListIterator() {
            this.list = MyArrayList.this;
            reset();
        }

        @Override
        public boolean hasNext() {
            return array[index] != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current = array[index];
            index++;

            return current;
        }

        @Override
        public void remove() {

        }

        public void reset() {
            index = 0;
        }
    }
}
