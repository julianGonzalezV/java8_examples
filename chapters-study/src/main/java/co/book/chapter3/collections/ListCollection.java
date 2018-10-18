package co.book.chapter3.collections;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {

    public static void main(String ... args){
        List<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow")); // true si se insertó bien
        System.out.println(list.add("Sparrow")); // true
        System.out.println(list); // permite repetidos [Sparrow, Sparrow]


        /**
         * remove()
         */
        System.out.println("::remove()::::::::::::");
        List<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        System.out.println(birds.remove("cardinal")); // prints false
        System.out.println(birds.remove("hawk")); // prints true
        System.out.println(birds); // [hawk]

        /**
         *clear() isEmpty() and size()
         */

        System.out.println("::clear() isEmpty() and size()::::::::::::");
        birds.clear();
        System.out.println(birds.isEmpty()); // true
        System.out.println(birds.size()); // 0
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        System.out.println(birds.isEmpty()); // false
        System.out.println(birds.size()); // 2
    }
}
