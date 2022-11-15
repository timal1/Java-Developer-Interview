package ru.timlad;

import java.util.Iterator;

public class MyListMain {

    public static void main(String[] args) {

        MyList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(5);
        myLinkedList.add(7);
        myLinkedList.add(8);
        myLinkedList.add(9);

        testIterator(myLinkedList);

        System.out.println();
        System.out.println("--------------------------");


        myLinkedList.insert(2, 10);
        testIterator(myLinkedList);


        System.out.println();
        System.out.println("--------------------------");


        System.out.println(myLinkedList.get(1));

        System.out.println();
        System.out.println("--------------------------");

        myLinkedList.delete(3);
        testIterator(myLinkedList);

        System.out.println();
        System.out.println("--------------------------");


        MyList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        testIterator(myArrayList);

        System.out.println();
        System.out.println("--------------------------");

        myArrayList.insert(2, 56);
        testIterator(myArrayList);

        System.out.println();
        System.out.println("--------------------------");

        myArrayList.delete(4);
        testIterator(myArrayList);

        System.out.println();
        System.out.println("--------------------------");

    }

    private static void testIterator(MyList myList) {

        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.print(integer + " ");
        }
    }
}
