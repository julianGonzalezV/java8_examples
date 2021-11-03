package co.book.chapter7._6_synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerV2 {
    /**
     * Atomic is the property of an operation to be carried out as a single unit of execution
     without any interference by another thread,  not allowing any other threads to access the
     variable during the operation a kind of synchronized
     */
    private AtomicInteger sheepCount = new AtomicInteger();
    private void incrementAndReport() {
        System.out.print((sheepCount.incrementAndGet())+" ");
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(8);
            //con esta implementacion lo que se asegura es que todos los computos se van a realizar , pero no asegura
            //que la salida va a ser en orden
            SheepManagerV2 manager = new SheepManagerV2();
            for(int i=0; i<90; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
