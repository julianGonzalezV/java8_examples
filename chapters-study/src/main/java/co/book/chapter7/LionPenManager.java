package co.book.chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {
    private void removeAnimals() { System.out.println(Thread.currentThread().getName()+" Removing animals"); }
    private void cleanPen() { System.out.println(Thread.currentThread().getName()+" Cleaning the pen"); }
    private void addAnimals() { System.out.println(Thread.currentThread().getName()+" Adding animals"); }
    public void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }


    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            //al aplicar wait acá el sistema espera hasta qeu el ultimo thread ejecute esta tarea
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
// Handle checked exceptions here
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            //IMPORTANTE: se debe asegurar que el pool de hilos sea por lo menos del mismo tamaño de
            //la cantidad CyclicBarrier si le mermamos a se puede estar colgandp
            LionPenManager manager = new LionPenManager();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                    () -> System.out.println("*** Pen Cleaned!"));

            for(int i=0; i<4; i++)
                //service.submit(() -> manager.performTask());//con esta no era seguro porque existe la posibilidad que al estar
                //un zookeper limpiando adicionen un animal con el adentro :)

                //Ahora si con esta implementaciÓN estamos seguros que ya todos limpiaron y ahora SI se puede iniciar a
                //meter animales O QUE ENTREN A LIMPIAR Y ESTÉ EL ANIMCAL ALLÍ :)
                service.submit(() -> manager.performTask(c1 , c2));

        } finally {
            if(service != null) service.shutdown();
        }
    }
}
