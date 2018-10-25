package co.book.chapter3.java8_additions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
        Supplier<ArrayList> methodRef4 = ArrayList::new; //ne llama al constructor vacio
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


    }
}
