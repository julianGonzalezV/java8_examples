package co.book.chapter3.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        //printList(keywords); // DOES NOT COMPILE, List<String> no se puede asignar a List<Object>, asi string sea por en si un object. que es el tipo que
        //recibe la funcion  printList(xx)
        printListV2(keywords); //si funciona porque el wild card ? dice que recibe de todo


        /**
         * Upper-Bounded Wildcards
         */

         // ArrayList<Number> listOfNumbers = new ArrayList<Integer>(); // DOES NOT COMPILE, a pesar
        //de que Integer hereda de number, recordemos que no es permitido asigaciones de diferentes tipos

        //si se requiere lo anterior entonces use Upper-Bounded Wildcards
        List<? extends Number> list = new ArrayList<Integer>();
        //list.add(new Integer(2)); no compila porque al usar Upper-Bounded Wildcards la lista se vuelve inmutable
//por lo anterior es que acudimos a la ota forma de crear listas, tal como sighue
        List<? extends Number> li = Arrays.asList(1, 2, 3);
        System.out.println("la suma es "+ total(li));

        List<? extends Zebra> zbras = new ArrayList<Zebra>();
        //zbras.add(new Zebra("sd"));// DOES NOT COMPILE, zbras es una lista inmutable
        //zbras.add(new Zebra());// DOES NOT COMPILE, zbras es una lista inmutable


        /**
         * Lower-Bounded Wildcards
         */
        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<Object>(strings);//note como se hace copy de todo el list strings
        objects.add("other"); // al alterar objects no se altera strings

        addSoundV4(strings);
        addSoundV4(objects);

        System.out.println("strings => "+strings);
        System.out.println("objects => "+objects);


        /**
         * Understand Generic Supertypes
         */

        List<? super IOException> exceptions = new ArrayList<Exception>();
        //exceptions.add(new Exception());	 // DOES NOT COMPILE ya que con lower bound podriamostener unalista de IOException y Exception no hace match
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());


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


    /**
     * Using Upper-Bounded Wildcards
     * @param list
     * @return
     */
    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number: list)
            count += number.longValue();
        return count;
    }

    public static void addSoundV1(List<?> list) {
        //list.add("quack");//NOT COMPILE, lista inmutable
    }

    /**
     * Upper-Bounded Wildcards
     * @param list
     */
    public static void addSoundV2(List<? extends Object> list) {
        //list.add("quack");///NOT COMPILE, lista inmutable
    }

    public static void addSoundV3(List<Object> list) {
        list.add("quack");///eL PROBLEMA ES QUE SOLO RECibe liste objects y no de strings también comolo nececisatmos
    }

    /**
     * Using lower-Bounded Wildcards
     * quiere decir que se reciben solo strings o clases que sean super class de la clase String
     * @param list
     */
    public static void addSoundV4(List<? super String> list) {
        list.add("quack");
    }



}
