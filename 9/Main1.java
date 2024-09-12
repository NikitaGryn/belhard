public class Main1 {
    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();

        Thread oddThread = new Thread(printNumbers::printOdd);
        Thread evenThread = new Thread(printNumbers::printEven);

        oddThread.start();
        evenThread.start();
    }
}
