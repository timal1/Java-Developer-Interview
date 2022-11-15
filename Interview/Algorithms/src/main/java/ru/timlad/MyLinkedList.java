package ru.timlad;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>{

    protected Node<E> first;
    protected Node<E> last;
    protected int size;

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public void add(E value) {
        first = new Node<E>(value, first);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(int index, E value) {

        Node<E> prevNode = node(index - 1);

       prevNode.next = new Node<>(value, node(index));



        size++;
    }

    @Override
    public boolean delete(int index) {

        Node<E> deleteNode = node(index);
        Node<E> prevDeleteNode = node(index - 1);
        prevDeleteNode.next = deleteNode.next;
        size--;
        return true;
    }

    Node<E> node(int index) {

        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Индекс: " + index + " выходит за пределы списка");
        }
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<E>{

        private final MyLinkedList<E> list;

        private Node<E> current;
        private Node<E> previous;

        public MyLinkedListIterator() {
            this.list = MyLinkedList.this;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E nextValue = current.item;
            previous = current;
            current = current.next;
            return nextValue;
        }

        @Override
        public void remove() {
            if (previous == null) {
                list.first = current.next;
                reset();
            } else {
                previous.next = current.next;
                if (!hasNext()) {
                    reset();
                } else {
                    current = current.next;
                }
            }
        }

        public void reset() {
            current = list.first;
            previous = null;
        }
    }
}
