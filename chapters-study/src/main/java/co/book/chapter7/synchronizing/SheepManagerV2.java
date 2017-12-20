package co.book.chapter7.synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerV2 {
    private AtomicInteger sheepCount = new AtomicInteger();
    private void incrementAndReport() {
        System.out.print((sheepCount.incrementAndGet())+" ");
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            //con esta implementacion lo que se asegura es que todos los computos se va a realizar , pero no asegura
            //que la salida va a ser en orden
            SheepManagerV2 manager = new SheepManagerV2();
            for(int i=0; i<70; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
