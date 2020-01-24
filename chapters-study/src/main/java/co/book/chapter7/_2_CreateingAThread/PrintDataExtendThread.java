package co.book.chapter7._2_CreateingAThread;


//No es comun usar esta implementacion por algunas de las restricciones que tiene como herencia y porque
//finalmente implementa runnable
public class PrintDataExtendThread extends Thread {

    public void run() {
        System.out.println("hey PrintDataExtendThread--->"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        /**
         * Note coo el thread de acá es el main
         */
        System.out.println("External Thread --->"+Thread.currentThread().getName());
        /**
         * A partir de ahora se crearan más
         */
        new PrintDataExtendThread().start();
        new PrintDataExtendThread().start();
        new PrintDataExtendThread().start();
        new PrintDataExtendThread().start();
    }
}

