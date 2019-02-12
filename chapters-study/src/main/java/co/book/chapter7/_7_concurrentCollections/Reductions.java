package co.book.chapter7._7_concurrentCollections;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reductions {

    public static void main(String ... args){
        usingCollect();
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
        System.out.println(set); // [f, l, o, w]

    }


    static void getStringLength(){
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length, k -> k,
                        (s1, s2) -> s1 + "," + s2));
    }
}
