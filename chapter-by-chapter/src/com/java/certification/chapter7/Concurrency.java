package com.java.certification.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrency {


    /*
    begin
Printing zoo inventory
Printing record: 0
Printing record: 1
Printing record: 2
Printing record: 3
Printing record: 4
end
Printing record: 5
Printing zoo inventory
     */
    //LO ANTERIOR ES UNA SALIDA POSIBLE, DE HECHO PASÓ Y ES PORQUE EL main (que es el que lo llama) es otro thread independiente

    /**
     * Ejemplo con ExecutorService y la inicializacion con Executors.newSingleThreadExecutor()
     */
    private  static void threadExecutor1(){
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin  "+Thread.currentThread().getName());
            //Exceute es la primera forma de enviar tareas a un thread
            //De acá en adelante es el mismo thread
            service.execute(() -> System.out.println(Thread.currentThread().getName()+" Printing zoo inventory"));
            service.execute(() -> {for(int i=0; i<6; i++)
                System.out.println(Thread.currentThread().getName()+" Printing record: "+i);}
            );
            service.submit(() -> {for(int i=0; i<16; i++)
                System.out.println(Thread.currentThread().getName()+" Printing submit record: "+i);}
            );
            service.execute(() -> System.out.println(Thread.currentThread().getName()+" Printing zoo inventory"));
            System.out.println("end  "+Thread.currentThread().getName());
        } finally {
            //SUPER IMPORTANTE LLAMAR AL SHUTDOWN
            //Ojo no siempre , isShutdown() and isTerminated() van a ser true cuando se llama a shutdown
            //pues implica que si tiene tareas pendientes entonces la debe terminar por lo cual seria true false
            //una vez culmina todas susus tareas ahí si sería true true , lo que si se asegura que el hilo no
            //reciba mas computos a realizar.
            //shutdownNow() Intenta detener all threads pero recordar que pueden existir tareas infinitas que se le haya enviado al
            //thread  y este nunca termine
            if(service != null) service.shutdown();
        }

    }

    public static void  main(String... args){
        threadExecutor1();
    }
}
