class PrintNumbers {
    private int number = 1;
    private final int MAX = 100;

    public synchronized void printOdd() {
        while (number <= MAX) {  
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Odd: " + number);
            number++;
            notify();
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {  
            if (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Even: " + number);
            number++;
            notify();
        }
    }
}