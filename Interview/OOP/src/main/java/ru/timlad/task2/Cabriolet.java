package ru.timlad.task2;

public class Cabriolet extends Car{
    @Override
    void move() {
        System.out.println("Cabriolet is moving");
    }

    @Override
    void stop() {
        System.out.println("Cabriolet is stop");
    }
}
