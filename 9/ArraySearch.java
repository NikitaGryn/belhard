import java.util.concurrent.Callable;

class ArraySearch implements Callable<Boolean> {
    private final int[] array;
    private final int start, end, target;

    public ArraySearch(int[] array, int start, int end, int target) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.target = target;
    }

    @Override
    public Boolean call() {
        for (int i = start; i < end; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }
}