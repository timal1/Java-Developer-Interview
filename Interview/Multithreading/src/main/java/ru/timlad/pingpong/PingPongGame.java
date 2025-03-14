package ru.timlad.pingpong;

public class PingPongGame {

    public static void main(String[] args) {
        var player = new Player();

        var threadPlayerOne = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    player.playerOne();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var threadPlayerTwo = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    player.playerTwo();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadPlayerOne.start();
        threadPlayerTwo.start();

    }
}
