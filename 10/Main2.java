import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 5, 3, 7, 9, 2, 4, 8, 6, 10};

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executor.submit(new MaxFinder(array, 0, array.length / 2));
        Future<Integer> future2 = executor.submit(new MaxFinder(array, array.length / 2, array.length));

        int max1 = future1.get();
        int max2 = future2.get();

        int max = Math.max(max1, max2);

        System.out.println("Maximum element in array: " + max);

        executor.shutdown();
    }
}