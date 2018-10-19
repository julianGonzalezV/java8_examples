package co.book.chapter3.collections;

import java.util.HashSet;
import java.util.Set;

public class SetCollection {
    public static void main(String ... args){

        Set<String> set = new HashSet<>();
        System.out.println(set.add("sparrow")); // true
        System.out.println(set.add("sparrow")); // false
        set.add("pandas");
        set.add("zebras");
        set.add("lions");
        System.out.println(set);//no permite repetidos
    }
}
