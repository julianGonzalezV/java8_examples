package co.book.java8.chapter7._2_CreateingAThread;


//No es comun usar esta implementacion por algunas de las restricciones que tiene como herencia y porque
//finalmente implementa runnable
public class PrintDataExtendThread extends Thread {

    public void run() {
        System.out.println("hey PrintDataExtendThread--->"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        /**
         * Note que el thread de aca es el main
         */
        System.out.println("External Thread --->"+Thread.currentThread().getName());
        /**
         * A partir de ahora se crearan mas
         */
        new PrintDataExtendThread().start();
        new PrintDataExtendThread().start();
        new PrintDataExtendThread().start();
        new PrintDataExtendThread().start();
    }
}

