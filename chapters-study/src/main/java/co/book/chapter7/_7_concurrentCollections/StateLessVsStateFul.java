package co.book.chapter7._7_concurrentCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StateLessVsStateFul {

    /**
     *Se recomeinda usar la version synchronized de List para
     * situaciones de concurrencia, ya que por ejemplo en ArrayList
     * pueda que dos hilos vayan a incrementar el tamaño del array
     * y queden una posición adicional vacia en la estructura
     */
    public static void stateFul(){
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());
        //Al hacer data.add(i) ya se esta modificando el estado
        //Evite esto al maximo
        Arrays.asList(1,2,3,4,5,6).parallelStream()
                .map(i -> {data.add(i); return i;}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
                .forEachOrdered(i -> System.out.print(i+" "));
        System.out.print("Segundo for=>");
        for(Integer e: data) {
            System.out.print(e+" ");
        }
    }

    /**
     * Note que si NO usa la version synchronizedList (que si se usa en stateFul), la salida puede
     * generar valores inesperados pueda que dos hilos vayan a incrementar el tamaño del array
     * y queden una posición adicional vacia en la estructura
     */
    public static void stateFulRegularArray(){
        List<Integer> data = new ArrayList<>();
        //Al hacer data.add(i) ya se esta modificando el estado
        //Evite esto al maximo
        Arrays.asList(1,2,3,4,5,6).parallelStream()
                .map(i -> {data.add(i); return i;}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
                .forEachOrdered(i -> System.out.print(i+" "));
        System.out.print("Segundo for=>");
        for(Integer e: data) {
            System.out.print(e+" ");
        }
    }

    public static void OrderBasedTasks() {
        System.out.println();
        System.out.println("This code consistently outputs the first value");
        System.out.println(Arrays.asList(1,2,3,4,5,6).stream().findAny().get());
        System.out.println("With parallelStream the result is no longer predictable");
        System.out.println(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get());

        /**
         * Ojo debe tener en cuenta que existen ordered operations que lo que quiere decir es que
         * asi se ejecuten sobre serial o parallel structures el resultado sera el mismo para ambos
         * pues las operaciones son Ordered, lo que si puede pasar es que en paraller structures
         * el performance se dañe notoriamente
         */
        System.out.println("Ordered ops");
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9).stream().skip(5).limit(2).findFirst());
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9).parallelStream().skip(5).limit(2).findFirst());
    }






    /**
     *
     * @param args
     */
    public static void main (String ... args){
        /*stateFul();
        System.out.println();
        stateFulRegularArray();
        OrderBasedTasks();*/
    }


}
