package co.book.java8.chapter4.functional.operations;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorAndBinary {
    public static void  main(String... args){
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));


        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick


        BinaryOperator<Integer> b3 = Integer::sum;
        BinaryOperator<Integer> b4 = (x, y) -> x*y;
        System.out.println(b3.apply(3, 6)); // baby chick
        System.out.println(b4.apply(3, 6)); // baby chick


    }
}
