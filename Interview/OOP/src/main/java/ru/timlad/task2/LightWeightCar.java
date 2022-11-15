package ru.timlad.task2;

class LightWeightCar extends Car implements Open, Close{

    @Override
    public void open() {
        System.out.println("LightWeightCar is open");
    }

    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    }

    @Override
    public void stop() {

        System.out.println("LightWeightCar is stop");
    }

    @Override
    public void close() {

        System.out.println("LightWeightCar is close");
    }
}

