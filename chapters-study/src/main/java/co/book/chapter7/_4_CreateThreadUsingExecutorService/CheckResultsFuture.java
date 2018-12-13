package co.book.chapter7._4_CreateThreadUsingExecutorService;

import java.util.concurrent.*;

/**
 * Version del CheckResults del paquete _3_pollingWithSleep que usa
 * Futures como resultado de la operación
 */
public class CheckResultsFuture {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for(int i=0; i<500000000; i++) CheckResultsFuture.counter++;
            });
            //el get acá siempre retornará null mas adelante se verá como existen otras clases que si
            // devuielven un valor futuro
            result.get(10, TimeUnit.SECONDS);//merme la unidad de tiempo a mili micro o nanno y note como yna de
            //ellas hace que se vaya por el catch porque lo que hace es esperar ése tiempo y si no se completa el futuro
            // se muere
            System.out.println("Reached!"+counter);
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service != null) service.shutdown();
        }
    }

}
