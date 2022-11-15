package ru.timlad;


public interface MyList<E> extends Iterable<E>{



    E get(int index);

    void add(E value);

    int size();

    void insert(int index, E value);

    boolean delete(int index);


    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}
