package co.book.java8.chapter7._6_synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerV4 {
    private int sheepCount = 0;

    /**
     * A diferencia de la V3 aca se sicroniza la ejecución de la tarea :)
     * OJO: ADEMaS ASi SIEMPRE ASEGURARa EL ORDEN!!! PORque se sincronizó la ejecución en lugar de la
     * creacipon como en la V3
     */
    private void incrementAndReport() {
        synchronized (this) {
        System.out.print((++sheepCount +" "));
        }
    }

    /**
     * El método anterior y este son lo mismo solo cambia la ubicación de
     * synchronized
     */
    private synchronized void  incrementAndReport2() {
        System.out.println(Thread.currentThread().getName()+ " contador = "+ sheepCount);

            System.out.print((++sheepCount +" "));
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            //con esta implementacion lo que se asegura es que todos los computos se va a realizar , pero no asegura
            //que la salida va a ser en orden 
            SheepManagerV4 manager = new SheepManagerV4();

            for(int i=0; i<180; i++) {
                /**
                 * Ojo aca se crean los hilos y se envian a ejecutar peeero
                 * al estar el método de ejecucion "incrementAndReport" con synchronized
                 * entonces los hilos deben de esperar
                 */
                    service.submit(() -> manager.incrementAndReport2());

            }

        } finally {
            if(service != null) service.shutdown();
        }
    }
}
