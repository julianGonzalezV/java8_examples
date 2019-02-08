package co.book.chapter7._7_concurrentCollections;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentClasses {

    public static void ConcurrentHMap(){
        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));

    }

    public static void ConcurrentLinkedQ(){
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println("peek =>" +queue.peek());
    }

    public static void ConcurrentLinkedDeq(){
        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        System.out.println(deque.peek());
        System.out.println(deque.pop());
    }


    /**
     * Note como a pesar de que se itera y a la vez se adicionan elementos en LInput
     * al hacer System.out.print(item+" "); dentro del for muestra solo los elementos originales de la
     * lista INTERESANTE PARA TEMAS DE CONCURRENCIA
     *
     * CopyOnWriteArrayList: Cada vez que existe una operacion de added, modifi ed, or removed
     * tooodos los elementos se copian en una nueva estructura
     *
     * @param LInput
     */
    public static void copyOnWriteArrayList(List<Integer>  LInput){
        //List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
        for(Integer item: LInput) {
            System.out.print(item+" ");
            LInput.add(9);
        }
        System.out.println();
        //Pero cuando termina su tamanio si incluye los registros que agtregó en el for
        System.out.println("Size: "+LInput.size());

    }

    /***
     * Funciona como un Queue normal,  pero contiene métodos que
     * esperaran cierto tiempo hasta que se complete la operación
     */
    public static void blockingQueue(){
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            /*
                Adds item to the queue waiting the specified time,
                returning false if time elapses before space is available
             */
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            /*
            Poll:
                Retrieves and removes an item from the queue, waiting
                the specified time, returning null if the time elapses
                before the item is available
             */
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            System.out.println("blockingQueue => La ejecución fué interrumpida");
        }
    }

    /**
     * Misma especificacion de la anterior con la diferencia que Dqueue es
     * una cola pura
     */
    public static void blockingDeQueue(){
        try {
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            System.out.println("blockingDDQueue => La ejecución fué interrumpida");
        }
    }

    public static void main(String ... args){

        ConcurrentHMap();
        ConcurrentLinkedQ();
        ConcurrentLinkedDeq();
        /*
        Note como saca error de UnsupportedOperationException
         */
        //copyOnWriteArrayList(Arrays.asList(4,3,52));
        /**
         * Acá si funciona porque la estructura es concurrrente
         * Úselo en ambinetes de concurrencia donde la operación de lectura es
         * más común que la escritura
         */
        copyOnWriteArrayList(new CopyOnWriteArrayList<>(Arrays.asList(4,3,52)));
    }
}
