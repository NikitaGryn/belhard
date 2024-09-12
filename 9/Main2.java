import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        String[] files = {"file1.txt", "file2.txt", "file3.txt", "file4.txt"};

        for (String file : files) {
            executor.submit(new FileDownloader(file));
        }

        executor.shutdown();
    }
}