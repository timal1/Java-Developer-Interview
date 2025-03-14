package ru.timlad.pingpong;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {
    Logger logger = Logger.getLogger("Player");

    private boolean state;

    public synchronized void playerOne() throws InterruptedException {

        while (state) {
            this.wait();
        }

        logger.log(Level.INFO, "Ping");
        state = true;
        this.notify();
    }

    public synchronized void playerTwo() throws InterruptedException {
        while (!state) {
            this.wait();
        }
        logger.log(Level.INFO, "Pong");
        state = false;
        this.notify();
    }

}
