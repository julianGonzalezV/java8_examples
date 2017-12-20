package co.book.chapter7.synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {
    private int sheepCount = 0;
    private void incrementAndReport() {
        System.out.print((++sheepCount)+" ");
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            //com hay 20 hilos concurrente eontonces se pueden tener salidas como
            //1 2 2 3 4 5 6 7 8 9
            //Note como el computo 10 se pierde y el 2 se duplica, esto se dá por no ser safe thread
            // dos hilos en este caso vieron el mismo valor para la variable sheepCount y realizaron la
            //operacion
            SheepManager manager = new SheepManager();
            for(int i=0; i<70; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
