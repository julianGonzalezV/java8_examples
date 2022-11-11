package co.book.java8.chapter3.collections;

import java.util.*;

/**
 * ALLOW DUPLICATED ITEMS
 *
 * Using ArrayList allow You  look up any element in constant time
 Adding or removing an element is slower than accessing an element
 good choice when you are reading more often
 summary:

 ::::::::Performance::::::::
 Search --> O(1): Maybe a binary search algorithm is used
 Insert --> O(n)
 Remove --> O(n)

 Sort: It uses Quick sort algorithm  O(n log n)  BUT the worst case is O(n^2)

 */
public class ListCollection {

    private static List listZoo(){

        String str = "a, b, c, a, d, e, b, f, g";

        List<String> inputList = Arrays.asList(str.split(","));

        List<String> list = new ArrayList<>();
        list.add("pandas");
        list.add("zebras");
        list.add("lions");
        list.add("pandas");

        return list;
    }

    private static List listNumbers(){
        List<Integer> list = new ArrayList<>();
        list.add(77);
        list.add(10);
        list.add(77);
        list.add(8);
        return list;
    }

    private static List listNumbersSort(){
        List<Integer> list = new ArrayList<>();
        list.add(77);
        list.add(10);
        list.add(77);
        list.add(8);
        list.sort(null);
        return list;
    }

    private static List listNumbersSortReverser(){
        List<Integer> list = new ArrayList<>();
        list.add(77);
        list.add(10);
        list.add(77);
        list.add(8);
        list.sort(Collections.reverseOrder());
        return list;
    }

    private static List listNumbersCustomSort(){
        Comparator<Integer> byEven = (x, y) -> {
          if(x % 2 > 0) return 1;
          else return -1;
        };

        List<Integer> list = new ArrayList<>();
        list.add(77);
        list.add(10);
        list.add(77);
        list.add(8);
        list.sort(byEven);
        return list;
    }


    private static List listZoo2(){

        List<String> list = new ArrayList<>();
        list.add("pandas");
        list.add("zebras");
        list.add("lions");

        System.out.println(list.get(1));
        return list;
    }

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


        /**
         * contains()
         */

        System.out.println("::::::contains()::::::::::::");
        System.out.println(birds.contains("hawk"));


        /**
         * Using the List Interface
         */
        System.out.println("Strings: "+listZoo());
        System.out.println("Numbers: "+ listNumbers()); // again, It sorts based on the inserted order
        System.out.println("Sorting :::::");
        System.out.println("Natural: "+ listNumbersSort());
        System.out.println("Custom Sort: "+listNumbersCustomSort());

    }
}
