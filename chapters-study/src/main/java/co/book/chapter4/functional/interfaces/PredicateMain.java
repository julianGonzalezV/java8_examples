package co.book.chapter4.functional.interfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateMain {
    public static void  main(String... args){

        //Usamos Predicate para evaluar condicionales, note como se pospone el computo, hasta que no se llama el método
        //de la interfaz funcional , no se ejecuta el computo, imagine grandes piezas de codigo que se evaluen a boolean

        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println(p1.test(""));
        System.out.println(p2.test(""));

        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(b1.test("chicken", "chicki"));
        System.out.println(b2.test("chicken", "chick"));
    }
}
