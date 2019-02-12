package co.book.chapter7._7_concurrentCollections;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reductions {



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


    /**
     *  Firma:
     *  <R> R collect(Supplier<R> supplier,
     BiConsumer<R, ? super T> accumulator, : debe ser una op asociativa, incorpora un elemento adiconal al resultado
     BiConsumer<R, R> combiner); : debe ser una op asociativa, indica como se unen/combinan 2 valores

     Para combinar resultados se debe usar concurrent collection para asegugar que no se genere un
     ConcurrentModificationException

     Requirements for Parallel Reduction with collect()

     The stream is parallel.
     The parameter of the collect operation has the Collector.Characteristics.CONCURRENT
     characteristic.
     Either the stream is unordered, or the collector has the characteristic
     Collector.Characteristics.UNORDERED .
     */
    static void usingCollect(){
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add,Set::addAll);
        /**
         * La siguiente implementación al no cumplir con las reglas de collect(While Collectors.
         toSet() does have the UNORDERED characteristic, it does not have the CONCURRENT
         characteristic;) entonces
         * no tendrá los beneficios de concurrencia
         */
        //Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set); // [f, l, o, w]

    }


    /**
     * Version del capitulo 4 pero esta vez con un stream paralelo y además
     * una reducción paralela pues toConcurrentMap cumple con las reglas
     */
    static void getStringLength(){
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        /**Primero la firma de toConcurrentMap es:
         *
         * toConcurrentMap(Function<? super T, ? extends K> keyMapper,
         Function<? super T, ? extends U> valueMapper,
         BinaryOperator<U> mergeFunction)
         *
         *
         * Lo que se le dice al collect acá es que ConcurrentMap va a ser ala estructura final
         * en que se debe acumular el resultado en donde el key será el tamanio de del string
         * y el value es eñ string y LA FUNCION DE MERGE es que cada string que tenga el mismo
         * tamanio se separará por coma ","
         */
        ConcurrentMap<Integer, String> map = ohMy.collect(Collectors.
                toConcurrentMap(String::length, k -> k,(s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap
    }


    /**
     * Guaranteeing that a particular stream will perform reductions in a parallel, as opposed
     to single-threaded, is often difficult in practice.
     pOR EJEMPLO
     escoja groupingByConcurrent() sobre groupingBy() y así sucesvamente con todas las
     estructuras concurrentes
     * @param args
     */

    public static void main(String ... args){
        //ParallelReductions();
        //usingCollect();
        getStringLength();
    }

}
