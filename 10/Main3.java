public class Main3 {
    public static void main(String[] args) {
        PingPongGame game = new PingPongGame();

        Thread pingThread = new Thread(() -> {
            try {
                game.ping();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread pongThread = new Thread(() -> {
            try {
                game.pong();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        pingThread.start();
        pongThread.start();
    }
}