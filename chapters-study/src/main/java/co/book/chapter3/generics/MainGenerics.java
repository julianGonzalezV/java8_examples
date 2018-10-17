package co.book.chapter3.generics;

import java.util.ArrayList;
import java.util.List;

public class MainGenerics {

    public static void main(String ... args){
        Elephant elephant = new Elephant("Elefante 1");
        Zebra zebra = new Zebra("zebra 1");

        Crate<Elephant> crateForElephant = new Crate<>();
        crateForElephant.packCrate(elephant);
        //crateForElephant.packCrate(zebra);//no compila
        Elephant inNewHome = crateForElephant.emptyCrate();
        System.out.println(inNewHome.getName());

        //

        Crate<Zebra> crateForzb = new Crate<>();
        crateForzb.packCrate(zebra);
        Zebra zinNewHome = crateForzb.emptyCrate();
        System.out.println(zinNewHome.getName());


        /**
         * Bounds
         */

        /**
         * 1- Unbounded Wildcards
         */

        List<String> keywords = new ArrayList<>();
        keywords.add("java java do");
        //printList(keywords); // DOES NOT COMPILE, List<String> no se puede asignar a List<Object>, así string sea por en si un object. que es el tipo que
        //recibe la funcion  printList(xx)
        printListV2(keywords); //si funciona porque el wild card ? dice que recibe de todo

    }


    /**
     *
     * @param list Unbounded Wildcards VERSION
     */
    public static void printListV2(List<?> list) {
        for (Object x: list) System.out.println(x);
    }

    public static void printList(List<Object> list) {
        for (Object x: list) System.out.println(x);
    }

}
