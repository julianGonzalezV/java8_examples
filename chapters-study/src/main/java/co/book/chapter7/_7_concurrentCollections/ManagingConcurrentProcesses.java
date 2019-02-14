package co.book.chapter7._7_concurrentCollections;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManagingConcurrentProcesses {
    /*Main sin CyclicBarrier
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            for(int i=0; i<4; i++)
                service.submit(() -> manager.performTask());
        } finally {
            if(service != null) service.shutdown();
        }
    }*/

    /**
     * Main con CyclicBarrier
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService service = null;
        LionPenManager manager = new LionPenManager();
        CyclicBarrier c1 = new CyclicBarrier(4);
        CyclicBarrier c2 = new CyclicBarrier(4,() -> System.out.println("*** Pen Cleaned!"));
        try {
            service = Executors.newFixedThreadPool(4);
            for(int i=0; i<4; i++)
                service.submit(() -> manager.performTaskV2(c1,c2));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}


class LionPenManager{
    private void removeAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.println("Adding animals"); }
    public void performTask() {

        /**
         * Ojo el syso comentado lo coloque por probar y esto hizo que por algún motivo se corra este
         * método llamando secuencialmente sus métodos internos y al parecer solo lo ejecuta un solo hilo
         * comentado se nota como varios hilos lo puede agarrar ya qu epuede salir varias veces
         * Removing animals
         Removing animals
         */
        // System.out.println(":::: New Iter =>  ");
        removeAnimals();
        cleanPen();
        addAnimals();
    }

    public void performTaskV2(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            /**
             * Wow note como se ejeucta primero toodos y solo todos los llamados EN
             * UN SOLO PASO DE Removing animals, luego
             * Luego se ejecuta el otro tambien todos
             * y finalmente ahí si se hace addAnimals para que no se coman a las personas de mantenimiento del
             * zoo
             */
            removeAnimals();
            /**
             * cON WAIT DE C1 todos los hilos haran un stop dado que existe esta barrera y hasta que todos
             * los hilo no ejecuten este método no pueden pasar en el proceso
             * RECURDE QUYE  EN ESTE CASO removeAnimals() está siendo ejecutado en paralelo
             */
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
