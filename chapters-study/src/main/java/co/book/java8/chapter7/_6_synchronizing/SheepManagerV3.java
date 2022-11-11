package co.book.java8.chapter7._6_synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerV3 {
    private int sheepCount = 0;
    private void incrementAndReport() {
        System.out.print((++sheepCount +" "));
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            //con esta implementacion lo que se asegura es que todos los computos se va a realizar , pero no asegura
            //que la salida va a ser en orden 
            SheepManagerV3 manager = new SheepManagerV3();

            for(int i=0; i<180; i++) {
                /**
                 * El problema aún no se resuelve porque se esta
                 */
                synchronized (manager) {
                    service.submit(() -> manager.incrementAndReport());
                }
            }

        } finally {
            if(service != null) service.shutdown();
        }
    }
}
