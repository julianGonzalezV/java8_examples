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
     * y queden una posición adicional vacía en la estructura
     */
    public static void stateFul(){
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());
        //Al hacer data.add(i) ya se está modificando el estado
        //Evite esto al máximo
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
     * y queden una posición adicional vacía en la estructura
     */
    public static void stateFulRegularArray(){
        List<Integer> data = new ArrayList<>();
        //Al hacer data.add(i) ya se está modificando el estado
        //Evite esto al máximo
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
         * así se ejecuten sobre serial o parallel structures el resultado será el mismo para ambos
         * pues las operaciones son Ordered, lo que si puede pasar es que en paraller structures
         * el performance se dañe notoriamente
         */
        System.out.println("Ordered ops");
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9).stream().skip(5).limit(2).findFirst());
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9).parallelStream().skip(5).limit(2).findFirst());
    }


    /**
     *Recuerde la firma de reduction:
     * reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)
     * identity: The zero value
     * accumulator: funcion que indica como se compbinar el resultado actual al acumularo
     * combiner: Function to combiner two values
     *
     * Requirements for reduce() Arguments
     ■ The identity must be defined such that for all elements in the stream u ,
     combiner.apply(identity, u) is equal to u .
     ■ The accumulator operator op must be associative and stateless such that (a op b) op c
     is equal to a op (b op c) .
     ■ The combiner operator must also be associative and stateless and compatible with the
     identity, such that for all u and t combiner.apply(u,accumulator.apply(identity,t))
     is equal to accumulator.apply(u,t) .
     *
     */
    public static void ParallelReductions() {
       /* System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .stream().reduce("",(c,s1) -> c + s1,(s2,s3) -> s2 + s3));*/

        /**
         * Version desmenusada :)
         * Noteel valor identidad
         */
        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .stream().reduce("x",(c,s1) -> {
                    System.out.println("c=> "+c+"  s1=> "+s1);
                    return c + s1;
                },(s2,s3) -> {
                    System.out.println("hola");

                    System.out.println("s2=> "+s2+"  s3=> "+s3);
                    return s2+s3;
                }));

        /**
         * En parallel el valor identidad se va para todos sus hilos o particiones
         */
        System.out.println("Versión Paralela");
        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .parallelStream().reduce("x",(c,s1) -> {
                    System.out.println("c=> "+c+"  s1=> "+s1);
                    return c + s1;
                },(s2,s3) -> {
                    //si se quita esta función entonces falla porque para el tipo de dato
                    //del list en este caso charater no sabría como unir los dos
                    return s2+s3;
                }));

        /**
         * Resultados:
         * Serial : xwolf
         * Paralelo: xwxoxlxf, Note como la x se reoartió en los computos paralelos
         * y la salida se vió afectada, porque X no es un valor identidad confiable
         */


        /**
         * La resta no cumple con las reglas del reduce, pues no es asociativa la función(ver arriba en al documentación de
         * éste método)
         */
        System.out.println(" NOT AN ASSOCIATIVE ACCUMULATOR");
        System.out.println(Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0,(a,b) -> {
                    return (a-b);
                })); // NOT AN ASSOCIATIVE ACCUMULATOR



        System.out.println(Arrays.asList("w", "o", "l", "f")
                .parallelStream().reduce("",(c,s1) ->  (c + s1)));
    }

    public static void ParallelCollect() {

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
        ParallelReductions();
    }


}
