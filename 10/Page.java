import java.util.concurrent.atomic.AtomicInteger;

class Page {
    private AtomicInteger viewCount = new AtomicInteger(0);

    public void viewPage() {
        int count = viewCount.incrementAndGet();
        System.out.println("Page viewed " + count + " times.");
    }
}