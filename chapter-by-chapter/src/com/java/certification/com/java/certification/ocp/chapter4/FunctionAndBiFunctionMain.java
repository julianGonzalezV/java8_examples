package com.java.certification.com.java.certification.ocp.chapter4;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndBiFunctionMain {
    //NOTA LLEVAR ESTOS CASOS QUE TEST DE PRUEBAS PARA EJEMPLIFICARLOS MEJOR

    public static void  main(String... args){

        //La siguiente convierte un String a un entero
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5


        //el siguiente parte de String y va a String, el tercer parametro es el resultado
        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick


    }
}
