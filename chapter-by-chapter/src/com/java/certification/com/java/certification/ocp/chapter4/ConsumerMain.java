package com.java.certification.com.java.certification.ocp.chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerMain {

    //NOTA LLEVAR ESTOS CASOS QUE TEST DE PRUEBAS PARA EJEMPLIFICARLOS MEJOR

    public static void  main(String... args){
        // note como se pospone el computo, hasta que no se llama el método
        //de la interfaz funcional , no se ejecuta el computo

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Annie");
        c1.accept("juli");
        c2.accept("Annie");


        //BiConsumer
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b1.accept("pollo1", 5);
        b2.accept("chick", 1);
        System.out.println(map);

    }
}