package co.book.chapter7._5_Callable;


import java.util.concurrent.*;

import static java.lang.Thread.*;

/**
 * ExecutorService tambien tiene una version de submit que recibe un callable
 * y retorna un objeto de tipo Future<T>
 */
public class AddData {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //example1(); //DESOomentar para verificar funcionamiento
        //waitingForAllTasksToFinish();
        schedulingTasksEg1();
        //repeatedlyTasks1();
        //repeatedlyTasks2();
    }

    private static void example1() throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> {
                sleep(5000);//simulando que la tarea toma 5 segundos y termina
                return 30+11;
            });
            /**
             * OJO note como esta tarea se puede ejecutar y continua con la
             siguiente línea, PEEROOOO si esta línea se coloca despues del System.out.println("Result Get es => "+result.get())
             no se ejecuta hasta que termine o se resuelva el futuro PORQUE lo necesita al hacer result.get()
             */
            System.out.println("Soy otra tarea ");
            System.out.println("Result Get es => "+result.get());//el get hace wait
            //Note como acá pordemos obtener el resultado
            //con runnable también es posible pero con una variable static pero note la simplicidad acá
            //PARA CONCURRENCY por lo general esta es la interface preferida por los developers (dice la teoría)


        } finally {
            if(service != null){
                System.out.println("shutting down");
                service.shutdown();
            }
        }
    }

    private static void waitingForAllTasksToFinish() throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> {
                sleep(5000);//simulando que la tarea toma 5 segundos y termina
                return 0;
            });

        } finally {
            if(service != null) service.shutdown();
        }

        /**
         * * OJO shutdown no cancela las tareas que ya se habían enviado previamente al hilo, sino que
         * espera que se se ejecuten y ahí si se termina POR ESO PUEDE LLEGAR A ESTA LÍNEA Y PREGUNTAR
         * LO SIGUIENTE
         */
        if(service != null) {
            service.awaitTermination(2000, TimeUnit.MILLISECONDS);
            // Check whether all tasks are finished
            if(service.isTerminated())
                System.out.println("All tasks finished");
            //escriba acuí lo que desee cuando tooodas
            //las tareas se terminan
            else
                System.out.println("At least one task is still running");
        }
    }


    /**
     * Casos
     * -Queremos que se ejecute en el futuro a tal hora
     * -Queremos que sea repetitiva
     *
     */
    private static void schedulingTasksEg1() throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            Runnable task1 = () -> {
                System.out.println("Ejecutando tarea 1"+Thread.currentThread().getName());
            };
            Callable<String> task2 = () -> {
                System.out.println("Inicia tarea 2"+Thread.currentThread().getName());
                return "Tarea 2 va a retornar";
            };
            Future<?> result1 = service.schedule(task1, 5000, TimeUnit.MILLISECONDS);
            Future<?> result2 = service.schedule(task2, 8000, TimeUnit.MILLISECONDS);
            // System.out.println("resultado tarea 2 => "+result2.get());//el get hace que bloquee el hilo, hace wait
            System.out.println("Esta línea se ejecuta");
            /**
             *  Note como en ambos Thread.currentThread().getName()
             *  retorna el mismo nombre
             */

            /**
             * Note como imprime
             *sout:
             Esta línea se ejecuta
             Ejecutando tarea 1
             Inicia tarea 2
             */

        }finally {
            /**
             * Validacion de nulidad para no ir a llamar shutdown
             * sobre algo que es null
             */
            if(service != null){
                System.out.println("shutdown()");
                service.shutdown();
            }
        }
    }

    private static void repeatedlyTasks1() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> {
            try {
                System.out.println("Inicia a Ejecutar tarea 1");
                sleep(5000);//simulando que la tarea toma 5 segundos y termina
                System.out.println("Termina tarea 1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        /**
         * No0te como scheduleAtFixedRate en este caso espera 7 segundos, inicia el task1 y cada 3 segundos vuelve y la ejecuta
         * sin importar cuando toma tkas1 que en este ejemplo le colocamos 5 segundos
         */
        service.scheduleAtFixedRate(task1,7000,3000,TimeUnit.MILLISECONDS);
    }

    private static void repeatedlyTasks2() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> {
            try {
                System.out.println("Inicia a Ejecutar tarea 1");
                sleep(5000);//simulando que la tarea toma 5 segundos y termina
                System.out.println("Termina tarea 1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        /**
         * scheduleWithFixedDelay: En este caso espera 7 segundos, inicia el task1 y cada 3 segundos vuelve y la ejecuta
         * Pero si la primera ejecución no ha terminado entonces este espera hasta lanzar la siguiente  ejecución de
         * la tarea.
         */
        service.scheduleWithFixedDelay(task1,0,3000,TimeUnit.MILLISECONDS);
    }
}

