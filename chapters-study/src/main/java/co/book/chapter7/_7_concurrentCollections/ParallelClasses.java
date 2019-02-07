package co.book.chapter7._7_concurrentCollections;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelClasses {


    /**
     * Creando un stream paralelo desde un stream sencillo
     * la idea de paralelo es que cada elementos se pude procesar por unhilo diferente
     * algo así como atender a la vez a todos las personas en una fila :)
     */
    public static Stream<Integer>  example1(){
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
        return stream.parallel();
    }


    /**
     * Creando stream paralelo desde una Java collection class,usando parallelStream()
     *
     */
    public static Stream<Integer>  example2(){
        return Arrays.asList(1,2,3,4,5,6).parallelStream();
    }



    /**
     * Processing Tasks in serial wayl
     * @return la impresion en la consola en  orden
     */
    public static void example3(){

        Stream st1 =  Arrays.asList(1,2,3,4,5,6).stream();
        st1.forEach(s -> System.out.print(s+" "));
        System.out.println("");
    }

    /**
     * Processing Tasks in Parallel
     * @return.
     * Note comola impresion en la salida no siempre es en order
     */
    public static void example4(){

        Stream st1 =  Arrays.asList(1,2,3,4,5,6).parallelStream();
        st1.forEach(s -> System.out.print(s+" "));
    }


    public static void main(String ... args){
        /**
         * con isParallel() podemos verificar si es un stream paralelo
         *
         */
        System.out.println(example1().isParallel());
        System.out.println(example2().isParallel());

        /**
         * Algunas operaciones hacen que el retorno siga siendo un stream paralelo  o no
         * 1) Mire el caso de concat
         * 2) Note el flatMap que devuelve un stream que ya no es paralelo
         */
        Stream<Integer> streamAfterConcat =  Stream.concat(example1(), example2());
        System.out.println(streamAfterConcat.isParallel());

        /*Stream<Integer> streamAfterFlatMap = example1().fla(x -> x+1);
        System.out.println(streamAfterFlatMap.isParallel());*/

        example3();

        System.out.println("example4 => ");
        example4();
    }

}
