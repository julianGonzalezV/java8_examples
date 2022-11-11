package co.book.java8.chapter3.collections;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * You use a set when you don’t want to allow duplicate entries.
 * Implementations
 * :::::::::1) HashSet:::::::::::::::
 HashSet--El que se usa comúnmente
 Search --> O(1)
 Insert --> O(1)
 Remove --> O(1)
 tradeoff---> Loose of order when inserting
 *HashSet is the most common used set.
 * :::::::::::::::::::::::::::::::::::::

 * :::::::::2) TreeSet:::::::::::::::
 *stores its elements in a sorted tree structure.
 * the set is always in sorted order. ( elimina el tradeoff de hashSet )
 * The tradeoff is that adding and checking if an element is present
 are both O(log n).
 */
public class SetCollection {

    private static Set zooSet(){
        Set<String> set = new HashSet<>();
        set.add("pandas");
        set.add("zebras");
        set.add("lions");
        set.add("pandas");
        return set;
    }

    private static Set numbersSet(){
        Set<Integer> set = new HashSet<>();
        set.add(77);
        set.add(10);
        set.add(77);
        set.add(8);
        for (Integer integer: set) System.out.print(integer + ","); // 66,8,10,

        return set;
    }

    private static Set zooTreeSet(){
        Set<String> set = new TreeSet<>();
        set.add("pandas");
        set.add("zebras");
        set.add("lions");
        set.add("pandas");
        return set;
    }

    private static Set numbersTreeSet(){
        Set<Integer> set = new TreeSet<>();
        set.add(77);
        set.add(10);
        set.add(77);
        set.add(8);
        for (Integer integer: set) System.out.print(integer + ","); // 66,8,10,
        return set;
    }

    private static Set numbersNavigableSet(){
        /*
        E lower(E e) Returns greatest element that is < e, or null if no such element
        E floor(E e) Returns greatest element that is <= e, or null if no such element
        E ceiling(E e) Returns smallest element that is >= e, or null if no such element
        E higher(E e) Returns smallest element that is > e, or null if no such element */

        NavigableSet<Integer> set = new TreeSet();
        set.add(77);
        set.add(10);
        set.add(80);
        set.add(20);
        set.add(8);
        System.out.println(set.lower(10));
        System.out.println(set.floor(10));
        System.out.println(set.ceiling(20));
        System.out.println(set.higher(20));
        System.out.println(set.higher(80));
        return set;
    }



    public static void main(String ... args){

        Set<String> set = new HashSet<>();
        System.out.println(set.add("sparrow")); // true
        System.out.println(set.add("sparrow")); // false
        set.add("pandas");
        set.add("zebras");
        set.add("lions");
        System.out.println(set);//no permite repetidos, no asegura el orden de insersion
        /**
         * Using the Set Interface
         */
        System.out.println("::::::Set::::::::");
        System.out.println("Set of Strings: "+zooSet());
        System.out.println("Set of Numbers: "+ numbersSet());

        System.out.println("::::::TreeSet:::::::::");
        System.out.println("Strings: "+zooTreeSet());//note como se esta ordenado :) it used Comparable
        System.out.println("Numbers: "+ numbersTreeSet());//note como se esta ordenado :)

        System.out.println("NavigableSet => ");
        System.out.println("Numbers: "+numbersNavigableSet());
    }
}
