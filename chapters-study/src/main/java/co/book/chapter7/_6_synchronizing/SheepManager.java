package co.book.chapter7._6_synchronizing;

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
            service = Executors.newFixedThreadPool(20);// el pool se define con 20 hilos dispuestos a
            //tomar cualquier tarea.
            //como hay 20 hilos concurrente entonces se pueden tener salidas como
            //1  3 4 5 6 7 8 9 2
            //Note como el computo del 2 se pierde y se coloca al final(si en el for con 10 no sucede entonces incremente, eg 90 :) ),
            // esto se dá por no ser safe thread, o se pueden repetir vaslorea a la salida
            // dos hilos en este caso vieron el mismo valor para la variable sheepCount y realizaron la
            //operacion
            SheepManager manager = new SheepManager();
            for(int i=0; i<90; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
