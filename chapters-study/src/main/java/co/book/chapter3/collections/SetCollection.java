package co.book.chapter3.collections;

import java.util.HashSet;
import java.util.Set;

public class SetCollection {
    public static void main(String ... args){

        Set<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow")); // true
        System.out.println(set.add("Sparrow")); // false
        System.out.println(set);//no permite repetidos
    }
}
