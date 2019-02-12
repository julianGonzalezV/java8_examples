package co.book.chapter7._7_concurrentCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StateLessVsStateFul {

    /**
     *Se reomeinda usar la version synchronized de List para
     * situaciones de concurrencia, ya que por ejemplo en ArrayList
     * pueda que dos hilos vayan a incrementar el tamaño del array
     * y queden vacíos
     */
    public static void stateFul(){
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());
        //Al hacer data.add ya se está modificando el estado
        Arrays.asList(1,2,3,4,5,6).parallelStream()
                .map(i -> {data.add(i); return i;}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
                .forEachOrdered(i -> System.out.print(i+" "));
        System.out.println();
        for(Integer e: data) {
            System.out.print(e+" ");
        }
    }

    /**
     *
     * @param args
     */
    public static void main (String ... args){
        stateFul();
    }


}
