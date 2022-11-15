package ru.timlad.task2;


class Lorry extends Car implements Open, Close{

    public void move(){
        System.out.println("Lorry is moving");
    }
    public void stop(){
        System.out.println("Lorry is stop");
    }

    @Override
    public void open() {
        System.out.println("Lorry is open");
    }

    @Override
    public void close() {
        System.out.println("Lorry is close");
    }
}

