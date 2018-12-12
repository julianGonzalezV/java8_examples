package co.book.chapter7._4_CreateThreadUsingExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService: eS LA INTERFACE
 * Executors: Es el factory cxlass
 */
public class zooInfo {
    public static void main(String[] args) {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            //El método execute lo que recibe es un runnable
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {for(int i=0; i<3; i++)
                System.out.println("Printing record: "+i);}
            );
            service.execute(() -> System.out.println("Printing zoo inventory 2"));
            System.out.println("end");
        } finally {
            /**
             * OJO shutdown no cancela las tareas que ya se habían enviado previamente al hilo
             * si eso es lo que desea entonces use shutdownNow()
             */
            if(service != null) service.shutdown();
        }
    }

}
