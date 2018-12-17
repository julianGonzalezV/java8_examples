package co.book.chapter7._5_Callable;


import java.util.concurrent.*;

/**
 * ExecutorService tambien tiene una version de submit que recibe un callable
 * y retorna un objeto de tipo Future<T>
 */
public class AddData {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //example1(); //DESOomentar para verificar funcionamiento
        //waitingForAllTasksToFinish();
        schedulingTasksEg1();
    }

    private static void example1() throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> {
                Thread.sleep(5000);//simulando que la tarea toma 5 segundos y termina
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
                Thread.sleep(5000);//simulando que la tarea toma 5 segundos y termina
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
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Ejecutando tarea 1");
        Callable<String> task2 = () -> {
            System.out.println("Inicia tarea 2");
            return "Tarea 2 va a retornar";
        };
        Future<?> result1 = service.schedule(task1, 3000, TimeUnit.MILLISECONDS);
        Future<?> result2 = service.schedule(task2, 7000, TimeUnit.MILLISECONDS);
       // System.out.println("resultado tarea 2 => "+result2.get());//el get hace que bloquee el hilo, hace wait
        System.out.println("Esta línea se ejecuta");
        /**
         * Note como imprime
         *sout:
             Esta línea se ejecuta
             Ejecutando tarea 1
             Inicia tarea 2
         */
    }
}

