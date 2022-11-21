package ru.timlad.pingpong;

public class Player {

    private boolean state;

    public synchronized void playerOne() throws InterruptedException {
        while (state) {
            this.wait();
        }
        System.out.println("Ping");
        state = !state;
        this.notify();
    }

    public synchronized void playerTwo() throws InterruptedException {
        while (!state) {
            this.wait();
        }
        System.out.println("Pong");
        state = !state;
        this.notify();
    }

}
