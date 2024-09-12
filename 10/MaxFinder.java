import java.util.concurrent.*;

class MaxFinder implements Callable<Integer> {
    private final int[] array;
    private final int start, end;

    public MaxFinder(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int max = array[start];
        for (int i = start; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}