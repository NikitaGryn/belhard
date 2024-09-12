import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FileDownloader implements Runnable {
    private final String fileName;

    public FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Downloading file: " + fileName + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Downloaded file: " + fileName);
    }
}

