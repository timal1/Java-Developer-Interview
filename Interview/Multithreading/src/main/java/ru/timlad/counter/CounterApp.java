package ru.timlad.counter;

import java.util.concurrent.locks.ReentrantLock;

public class CounterApp {
    public static void main(String[] args) {

        var counter = new Counter();
        var lock = new ReentrantLock();

        var threadIncrement = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    counter.increment();
                } finally {
                    lock.unlock();
                }
            }
        });

        var threadDecrement = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    counter.decrement();
                } finally {
                    lock.unlock();
                }
            }
        });

        threadIncrement.start();
        threadDecrement.start();
    }
}
