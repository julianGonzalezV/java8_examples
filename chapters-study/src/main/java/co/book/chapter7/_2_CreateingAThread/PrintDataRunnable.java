package co.book.chapter7._2_CreateingAThread;

public class PrintDataRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hey runnable--->"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Main--->"+Thread.currentThread().getName());
        new Thread(new PrintDataRunnable()).start();
        new Thread(new PrintDataRunnable()).start();
    }
}
