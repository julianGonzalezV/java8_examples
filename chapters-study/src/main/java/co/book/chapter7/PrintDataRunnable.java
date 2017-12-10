package co.book.chapter7;

public class PrintDataRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hey runnable"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new Thread(new PrintDataRunnable()).start();
    }
}
