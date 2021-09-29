package co.book.chapter3.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/** .:::::::Map Interface
 * You use a map when you want to identify values by a key.
 *
 * :::::::Map Implementations :::::::::::::::::
 * 1) :::::::HashMap::::::
 * it uses the hashCode() method
 * of the keys to retrieve their values more efficiently.
 * ADDING elements  takes CONSTANT time
 * CHECKING if an element is in the set takes CONSTANT time
 *The tradeoff is that you lose the order in which you inserted the elements
 *
 * 2) :::::::::::LinkedHashMap
 * much like HashMap but you DON'T lose the order in which you inserted the elements (insertion-order)
 *
 *
 * 3) :::::::TreeMap::::::
 *The main benefit is that the keys are
 always in sorted order.
 * The tradeoff is that adding and checking if a key is present are both
 O(log n).

 *
 * 2) :::::::A Hashtable::::::::::
 *it is really old and thread-safe
 *
 *
 */
public class MapCollection {

    private  static Map zooHashMap(){
        System.out.println("::::HashMap:::::");
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");

        map.put("lion", "sdfsd");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        System.out.println(map.get("koala"));  // bamboo
        System.out.println("El HashMap es => "+map);
        return map;
    }

    private  static Map zooLinkedHashMap(){
        System.out.println("::::LinkedHashMap:::::");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        System.out.println(map.get("koala"));  // bamboo
        System.out.println("El LinkedHashMap es => "+map);
        return map;
    }


    private  static Map zooTreeMap(){
        System.out.println("::::TreeMap:::::");
        Map<String, String> map = new TreeMap<>();
        map.put("koala", "bamboo");
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        System.out.println(map.get("koala"));  // bamboo
        System.out.println("El TreeMap es => "+map);
        return map;
    }


    private static Map example1 (){
        System.out.println("::::example1:::::");
        Map<String, Integer> map = new TreeMap<>();
        System.out.println(map.put("c", 1));
        System.out.println(map.put("b", 1));
        System.out.println(map.put("a", 1));
        //System.out.println(map.computeIfPresent("a", (k,v)->v+1));
        //System.out.println(map.computeIfPresent("a", (k,v)->v+1));
        //map.replace("a", map.get("a")+1);



        System.out.println(map);

        //map.
        /*
        Stream<String> s = Stream.of("a, b, c, a, d, e, b, f, g".split(","));// 3
        s.forEach(System.out::println);
        System.out.println("II) ");
       // s.forEach(System.out::println); genera error porque el stream ya fué operado
        */


        return map;
    }


    public static void main(String ... args){
        /*
        zooHashMap();//{koala=bamboo, giraffe=leaf, lion=meat}, no es el mismo orden de inserción :S
        zooLinkedHashMap();//{koala=bamboo, lion=meat, giraffe=leaf}, Es el mismo orden de insercion :)
        zooTreeMap();//{giraffe=leaf, koala=bamboo, lion=meat} alphabetic order
        */
        zooHashMap();
        zooLinkedHashMap();
        zooTreeMap();

        //example1();
    }
}
