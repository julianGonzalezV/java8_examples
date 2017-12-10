package co.book.chapter7;


//No es comun usar esta implementacion por algunas de las restricciones que tiene como herencia y porque
//finalmente extiende de runnable
public class PrintDataExtendThread extends Thread {

    public void run() {
        System.out.println("hey PrintDataExtendThread"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new PrintDataExtendThread().start();
    }
}

