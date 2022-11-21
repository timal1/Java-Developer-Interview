package ru.timlad.counter;

public class Counter {
    private int value;

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
        System.out.println(value);
    }

    public void decrement() {
        value--;
        System.out.println(value);
    }
}
