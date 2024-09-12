public class Main {
    public static void main(String[] args) {
        Page page = new Page();

        Runnable viewTask = page::viewPage;

        for (int i = 0; i < 5; i++) {
            new Thread(viewTask).start();
        }
    }
}