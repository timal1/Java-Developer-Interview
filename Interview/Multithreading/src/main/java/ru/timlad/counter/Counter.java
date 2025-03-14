package ru.timlad.counter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Counter {
    Logger logger = Logger.getLogger("Counter");
    private int value;

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
        logger.log(Level.INFO, String.valueOf(value));
    }

    public void decrement() {
        value--;
        logger.log(Level.INFO, String.valueOf(value));
    }
}
