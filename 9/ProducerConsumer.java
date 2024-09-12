import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int MAX_CAPACITY = 5;

    public synchronized void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            while (queue.size() == MAX_CAPACITY) {
                wait();
            }
            System.out.println("Produced: " + value);
            queue.add(value++);
            notify();
            Thread.sleep(1000);
        }
    }

    public synchronized void consume() throws InterruptedException {
        while (true) {
            while (queue.isEmpty()) {
                wait();
            }
            int value = queue.poll();
            System.out.println("Consumed: " + value);
            notify();
            Thread.sleep(1000);
        }
    }
}