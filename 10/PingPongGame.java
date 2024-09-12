class PingPongGame {
    private boolean pingTurn = true;

    public synchronized void ping() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            while (!pingTurn) {
                wait();
            }
            System.out.println("Ping");
            pingTurn = false;
            notify();
        }
    }

    public synchronized void pong() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            while (pingTurn) {
                wait();
            }
            System.out.println("Pong");
            pingTurn = true;
            notify();
        }
    }
}
