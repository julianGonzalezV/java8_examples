package co.book.chapter3.java8_additions;

import java.util.*;
import java.util.function.*;

public class J8Main {

    public  static  void main(String... args){
        /**
         * ::::::::::Method References::::::::::::::::
         */

        /**
         * Consumer: takes a single parameter of any type and has a void return type, exactamente la firma de sort
         *
         */
        Consumer<List<Integer>> methodRef1 = Collections::sort;

        /**
         * Predicate:: is a functional inter-
         face that takes a single parameter of any type and returns a boolean
         */
        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith; //forma :: o method reference
        Predicate<String> lambda2 = s -> str.startsWith(s); // forma usando lambda

        /**
         * Supplier::: It doesn’t take any parameters and returns any type
         */
        Supplier<ArrayList> methodRef4 = ArrayList::new; //se llama al constructor vacio
        Supplier<ArrayList> lambda4 = () -> new ArrayList(); //con labmda es más explicito

        /**
         * ::::::::::::::::::::::::::::::::::::: Java 8 list additions:::::::::::::::::::::::::::::::::::::
         */

        /**
         * Removing Conditionally
         * Firma:
         *
         * boolean removeIf(Predicate<? super E> filter)
         *
         * Recordar que Predicate takes a single parameter of any type and returns a boolean
         */
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        list.add("Architect");
        System.out.println(list); // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));//ojo no se puede escribir como method reference Since
        //// startsWith takes a parameter that isn’t s
        System.out.println(list); // [Magician]

        /**
         * Updating All Elements
         * void replaceAll(UnaryOperator<E> o)
         *
         * UnaryOperator:: takes one parameter and returns a value of the same
         type

         Es como un map en scala
         */

        List<Integer> listUpdate = Arrays.asList(1, 2, 3);
        listUpdate.replaceAll(x -> x*2);
        System.out.println(listUpdate); // [2, 4, 6]


        /**
         * Looping through a Collection
         */
        System.out.println("Traditional Way");
        List<String> cats = Arrays.asList("Annie", "Ripley");
        for(String cat: cats)
            System.out.println(cat);

        /**
         * Consumer: which takes a single parameter and doesn’t return
         anything.
         */
        System.out.println("Lambda Way");
        cats.forEach(c -> System.out.println(c));

        System.out.println("Method reference Way");
        cats.forEach(System.out::println);

        /**
         * Using New Java 8 Map APIs
         */
        System.out.println("update the value for a specific key in the map.");
        System.out.println("1) Replace sin ningún tipo de validación.");
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Jenny", "Tram");
        System.out.println(favorites); // {Jenny=Tram}

        System.out.println("2- Replace pero solo si no existe un value para el key en el map");
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null); // SI ACTUALIZA
        favorites.putIfAbsent("Jenny", "Tram");//NO ACTUALIZA
        favorites.putIfAbsent("Sam", "Tram");//SI
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}

        /**
         * merge() method::::
         */
        /**
         * BiFunction parameters: INPUT1, INPUT2, RESULT
         */
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1: v2;
        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", "Tram");

        String jenny = favorites2.merge("Jenny", "Skyride", mapper);
        //lo anterior quiere deci que si para el key Jenny el valor "Skyride" es más grande del que contenga
        //actualmente enotnces actuliza por Skyride de lo eontrario deja el anterior
        String tom = favorites2.merge("Tom", "Skyride", mapper);
        /**
         * Note como podemos guardar el resultado en las variables jenny y tom POR SI SE LLEGASEN A NECSITAR
         * PARA ALGO
         */
        System.out.println(jenny);
        System.out.println(tom);
        System.out.println(favorites2); // {Tom=Skyride, Jenny=Bus Tour}


        /**
         *what happens if nulls or missing keys??
         */
        Map<String, String> favorites3 = new HashMap<>();
        favorites3.put("Sam", null);
        String v1 = favorites3.merge("Tom", "Skyride", mapper);
        //Cómo no existe el key "Tom" entonces la función mapper no se llama, pues generería un NullPointerException()
        //al hacer v1.lenght()
        String v2 = favorites3.merge("Sam", "Skyride", mapper);
        System.out.println("Valor de las variables: ");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(favorites3); // {Tom=Skyride, Sam=Skyride}

        /**
         * what happens when the mapping function is
         called and returns null????
         */

        BiFunction<String, String, String> mapperNull = (x, y) -> null;
        Map<String, String> favorites4 = new HashMap<>();
        favorites4.put("Jenny", "Bus Tour");
        favorites4.put("Tom", "Bus Tour");
        favorites4.merge("Jenny", "Skyride", mapperNull);
        favorites4.merge("Sam", "Skyride", mapperNull);
        System.out.println(favorites4); // {Tom=Bus Tour, Sam=Skyride}:
        //Jenny se elimina porque se le aplica el mapper to Null
        //Sam se crea porque no existía


        /**
         * computeIfPresent and computeIfAbsent
         */

        /**
         * 1) computeIfPresent: Se aplica solo si se llega a encontral el Key
         */
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        BiFunction<String, Integer, Integer> mapperAdd = (k, v) -> v + 1;
        Integer jenny2 = counts.computeIfPresent("Jenny", mapperAdd);
        Integer sam2 = counts.computeIfPresent("Sam", mapperAdd);
        System.out.println(counts); // {Jenny=2}
        System.out.println(jenny2); // 2
        System.out.println(sam2); // null

        /**
         * 2) computeIfAbsent: Se ejecuta colo si el key no existe o es de valor Null
         */
        Map<String, Integer> counts2 = new HashMap<>();
        counts.put("Jenny", 15);
        counts.put("Tom", null);
        Function<String, Integer> mapperToOne = (k) -> 1;
        Integer jenny3 = counts2.computeIfAbsent("Jenny", mapperToOne); // , Jenny existe entonces no hace nada
        Integer sam3 = counts2.computeIfAbsent("Sam", mapperToOne); // sam no exiete entonces Sam=1
        Integer tom3 = counts2.computeIfAbsent("Tom", mapperToOne); // Tom es null entonces 1
        System.out.println(counts2); // {Tom=1, Jenny=15, Sam=1}


        /**
         *
         */

        Map<String, Integer> counts3 = new HashMap<>();
        counts3.put("Jenny", 1);
        counts3.computeIfPresent("Jenny", (k, v) -> null); // Debido a que el key Elimina el key del map solo aplica computeIfPresent
        counts3.computeIfAbsent("Sam", k -> null); // Así exista el Key o no al devolver null la función no hace nada en el caso de computeIfAbsent
        System.out.println(counts3); // {}


    }
}
