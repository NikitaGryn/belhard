import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main4 {
    public static void main(String[] args) throws Exception {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int target = 999999;

        ExecutorService executor = Executors.newFixedThreadPool(4);
        int chunkSize = array.length / 4;

        Future<Boolean> f1 = executor.submit(new ArraySearch(array, 0, chunkSize, target));
        Future<Boolean> f2 = executor.submit(new ArraySearch(array, chunkSize, chunkSize * 2, target));
        Future<Boolean> f3 = executor.submit(new ArraySearch(array, chunkSize * 2, chunkSize * 3, target));
        Future<Boolean> f4 = executor.submit(new ArraySearch(array, chunkSize * 3, array.length, target));

        if (f1.get() || f2.get() || f3.get() || f4.get()) {
            System.out.println("Element found!");
        } else {
            System.out.println("Element not found!");
        }

        executor.shutdown();
    }
}