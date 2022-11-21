package ru.timlad.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterApp {
    public static void main(String[] args) {

        Counter counter = new Counter();
        Lock lock = new ReentrantLock();

        Thread threadIncrement = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    counter.increment();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadDecrement = new Thread(() -> {
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
