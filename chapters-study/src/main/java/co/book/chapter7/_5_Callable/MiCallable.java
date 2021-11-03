package co.book.chapter7._5_Callable;

import java.util.concurrent.Callable;

public class MiCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("External Thread --->"+Thread.currentThread().getName());
        int total = 0;
        for (int i = 0; i < 5; i++) {

            total += i;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }


        return total;
    }

    public static void main(String[] args) throws Exception {
        /**
         * Note coo el thread de aca es el main
         */
        System.out.println("External Thread --->"+Thread.currentThread().getName());
        /**
         * A partir de ahora se crearan mas
         */
        new MiCallable().call();
        new MiCallable().call();
        new MiCallable().call();
        new MiCallable().call();
    }
}

