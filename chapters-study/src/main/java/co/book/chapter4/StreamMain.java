package co.book.chapter4;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {


    static String findNumber(int[] arr, int k) {
        System.out.println("entra1");

       return Arrays.stream(arr).filter(x-> x == k).toArray().length > 0? "Y":"N";
    }



    //NOTA LLEVAR ESTOS CASOS QUE TEST DE PRUEBAS PARA EJEMPLIFICARLOS MEJOR

    public static void  main(String... args){
        int[] arr ={1, 2, 5};
        System.out.println(findNumber(arr, 7));

        //example1, ejemplo de streams infinitos, llamar count en uno de estos se queda forever count
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

        //finitos
        Stream<Integer> ex1 = Stream.of(1,2,3,4,5);
        Stream<Integer> ex2 = ex1.map(x -> x + 2);
        Optional<Integer> min1 = ex2.min((s1, s2)-> s1 - s2);
        min1.ifPresent(System.out::println); // ape

        //using count
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");// 3
        //System.out.println(s.count()); AL APLICAR UN METODO CMO ESTE Que sería un terminal operartor el stream de
        // esfuma y no puede volver a ser usado, en éste caso se deberían tener varios streams


        Stream<String> str = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = str.min((s1, s2)-> s1.length() - s2.length());
        min.ifPresent(System.out::println); // ape



        //findAny() and findFirst()
        Stream<String> infinite = Stream.generate(() -> "chimp");
        s.findAny().ifPresent(System.out::println); // monkey
        infinite.findAny().ifPresent(System.out::println); // chimp


        //allMatch() , anyMatch() and noneMatch()
        //OJO si llamamos noneMatch() or allMatch() en un infinite se hubiera quedado corriendo y tendríamos que
        //matarlo
        System.out.println("allMatch() , anyMatch() and noneMatch()");
        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite2 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite2.anyMatch(pred)); // true



        //forEach()
        System.out.println("forEach()");
        //firma ----> void forEach(Consumer<? super T> action)
        //algunas consideraciones:
        //a loop with an if statement should be a fi lter instead

        //cannot use a traditional for loop (On Streams) to run because they don’t implement the Iterable interface.

        Stream<String> forS= Stream.of("Monkey", "Gorilla", "Bonobo");
        forS.forEach(System.out::print);



        //reduce()
        System.out.println("::::::::::::::::::.reduce():::::::::::::::::::::.");
        //The reduce() method combines a stream into a single object
        // lo siguiente en declarativa sería como un form normal y concatenando en una variable
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (x, y) -> x + y);
        System.out.println(word);// wolf




        Stream<String> stream1 = Stream.of("w", "o", "l", "f");
        String word2 = stream1.reduce("", String::concat);
        System.out.println(word2);// wolf
        Stream<Integer> stream2 = Stream.of(3, 5, 6);
        System.out.println(stream2.reduce(1, (a, b) -> a*b));

        System.out.println("::::::::::::::::::.reduce2:::::::::::::::::::::.");
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);
        Optional<Integer> opt1 = empty.reduce(op); // no output
        opt1.ifPresent(System.out::println);// no output
        oneElement.reduce(op).ifPresent(System.out::println); // 3
        threeElements.reduce(op).ifPresent(System.out::println); // 90


        System.out.println("::::::::::::::::::.reduce in a parallel way:::::::::::::::::::::.");
        BinaryOperator<Integer> ope = (a, b) -> a * b;
        Stream<Integer> streamP = Stream.of(3, 5, 6);
        System.out.println(streamP.reduce(1, ope, ope)); // 90



        System.out.println("::::::::::::::::::.Collect in a parallel way:::::::::::::::::::::.");
        //muy importante porque nos permite sacar los datos del stream, en la estructura que necesitemos
        Stream<String> streamCl = Stream.of("w", "o", "l", "f");
        //Sí miramos la firma de la funcion collect vemos que los BiConsumer serían los StringBuilder
        StringBuilder wordCl = streamCl.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(wordCl);



        // En el caso anterior note como el orden no interesa, ahora si lo que se desea es un orden,
        //el treeSet nos lo ofrece
        Stream<String> streamTs = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = streamTs.collect(TreeSet::new, TreeSet::add,TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]


        //otra forma de escribirlo es:
        Stream<String> streamTs2 = Stream.of("w", "o", "l", "f");
        //sacando los datos del Stream
        TreeSet<String> set2 = streamTs2.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set2); // [f, l, o, w]


        //If we didn’t need the set to be sorted, we could make the code even shorter:
        Stream<String> streamTs3 = Stream.of("w", "o", "l", "f");
        Set<String> set3 = streamTs3.collect(Collectors.toSet());
        System.out.println(set3); // [f, w, l, o]



        System.out.println("::::::::::::::::::.FILTER:::::::::::::::::::::.");
        // filter :  Stream<T> filter(Predicate<? super T> predicate)
        //Retorna otro Stream con los datos seleccionados en el filter
        Stream<String> sF = Stream.of("monkey", "gorilla", "bonobo");
        sF.filter(x -> x.startsWith("m")).forEach(System.out::println);// monkey

        /* hacer el de ordenar
        Stream<Integer> sI = Stream.of(5,4,1,3,2);
        sI.filter((x,y) -> (x - y).forEach(System.out::println);*/

        System.out.println();
        System.out.println("::::::::::::::::::.DISTINCT:::::::::::::::::::::.");
        //elimina los duplicados
        Stream<String> sD = Stream.of("duck", "duck", "duck", "goose");
        sD.distinct().forEach(System.out::println); // duckgoose


        System.out.println();
        System.out.println("::::::::::::::::.SKIP AND LIMIT:::::::::::::::::.");
        Stream<Integer> sSL = Stream.iterate(1, n -> n + 1);
        sSL.skip(5).limit(2).forEach(System.out::print);// 67

        System.out.println();
        System.out.println("::::::::::::::::.MAP:::::::::::::::::.");
        //The map() method on streams is for transforming data
        Stream<String> sM = Stream.of("monkey", "gorilla", "bonobo");
        sM.map(String::length).forEach(System.out::print);// 676
        //String::length is shorthand for the lambda x -> x.length()

        System.out.println();
        System.out.println("::::::::::::::::. flatMap():::::::::::::::::.");

        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(l -> l.stream()).forEach(System.out::println);


        System.out.println();
        System.out.println("::::::::::::::::. sorted():::::::::::::::::.");
        Stream<String> sSort = Stream.of("brown-", "bear-");
        sSort.sorted().forEach(System.out::print); // bear-brown-

        //De igual forma si lo que necesitamos es un ordenamiento personalizado
        //entonces hacemos uso del comparator
        Stream<String> sSort2 = Stream.of("brown bear-", "grizzly-");
        sSort2.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear-

        System.out.println();
        System.out.println("::::::::::::::::. peek:::::::::::::::::.");

        Stream<String> streamPeek = Stream.of("black bear", "brown bear", "grizzly");
        //Acá el resultado se guarda en count ..pero que pasaría si desearamos
        // conocer el motivo por qel cual coutn da 1 o 2 ..etc
        // Allí es donde estra a jugar la función PEEK lo que hace es
        long count = streamPeek.filter(elem -> elem.startsWith("b")).peek(System.out::println).count();
        System.out.println(count);


        //Streams allow you to use chaining and express what you want to accomplish rather than
        //how to do so.

        //EJERCICIOS::::

        /*dado un listado de nombres se debe obtener solo los 2 primeros
         en donde el tamño del nombre sea de 4 caracteres, además deben estar ordenados
         elfabeticamente
        Ejemplo: el siguiente listado como entrada ("Toby", "Anna", "Leroy", "Alex")
        debe retornar ("Alex", "Anna")
        */
        System.out.println("EJERCICIOS1::::");
        Stream<String> namesExample1 = Stream.of("Toby", "Anna", "Leroy", "Alex");
        namesExample1.filter(x-> x.length() < 5).sorted().limit(2).forEach(System.out::println);

        System.out.println("EJERCICIOS2:::: Dado una lista de numeros entonces obtener solo aquellos que son primos");
        IntStream.range(2, 100).filter(x-> isPrime(x)).forEach(System.out::println);


        System.out.println("EJERCICIOS2:::: FLATmAP");
        /*
        ,¿Cómo funciona exactamente flatMap? . FlatMap es una función que recibe una entrada
        y devuelve varias salidas para esa entrada . Esa es la diferencia con Map que tiene una entrada
        y devuelve una única salida. En este caso hemos convertido el array en un stream.

         */


        Stream<String> namesExample2 = Stream.of("www.google.com.co", "application.device", "frank.d.cardona", "192.168.10.12");
        String[] arrTest =  namesExample2.flatMap(x-> Stream.of(x.split("\\."))).toArray(size->new String[size]);
        System.out.println("arrTest => "+arrTest);
        Stream.of(arrTest).forEach(System.out::print);



    }

    /**
     *
     * @param n
     */
    private static boolean isPrime(int n){
         return IntStream.range(2, n).filter(x-> n%x == 0).count()<1;
    }

}
