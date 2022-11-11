package co.book.java8.chapter7;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toConcurrentMap;

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
            //De aca en adelante es el mismo thread
            service.execute(() -> System.out.println(Thread.currentThread().getName()+" Printing zoo inventory"));
            service.execute(() -> {for(int i=0; i<6; i++)
                System.out.println(Thread.currentThread().getName()+" Printing record: "+i);}
            );
            /**
             * sE RECOMIENDA MAS bien usar submit porque tiene un Futuro como respuesta
             * anque en este ejemplo nno lo estemos almacendando :) pero eso muestra
             * la felxibilidad que tiene , es decir que absorve a execute()
             */
            service.submit(() -> {for(int i=0; i<16; i++)
                System.out.println(Thread.currentThread().getName()+" Printing submit record: "+i);}
            );
            service.execute(() -> System.out.println(Thread.currentThread().getName()+" Printing zoo inventory"));
            System.out.println("end  "+Thread.currentThread().getName());
        } finally {
            //SUPER IMPORTANTE LLAMAR AL SHUTDOWN
            //Ojo no siempre , isShutdown() and isTerminated() van a ser true cuando se llama a shutdown
            //pues implica que si tiene tareas pendientes entonces la debe terminar por lo cual seria true false
            //una vez culmina todas sus tareas ahi si seria true true , lo que si se asegura es que el hilo no
            //reciba mas computos a realizar.
            //shutdownNow() Intenta detener all threads pero recordar que pueden existir tareas infinitas que se le haya enviado al
            //thread  y este nunca termine
            if(service != null) service.shutdown();
        }

    }


    /**
     *
     * @param vals
     * @return
     */
    public static ConcurrentMap<Integer, String> getMapFromLengthKeyToValStr(String... vals){
        ConcurrentMap<Integer, String> map1 = Stream.of(vals).parallel().collect(toConcurrentMap(String::length, k -> k,(s1, s2) -> s1 + "," + s2));
        return Stream.of(vals).parallel().collect(toConcurrentMap(String::length, k -> k,(s1, s2) -> s1 + "," + s2));
    }


}
