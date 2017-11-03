package com.java.certification.lambda.examples.methodreference;

/**
 * Created by juligove on 2017/10/24.
 */
public class MainExamples {

    public static void main(String... args){
        Convertidor<String, Integer> convert1 = from -> Integer.valueOf(from);
        int valor1 = convert1.convertir("3");
        System.out.println(valor1);

        //
        Convertidor<String, Integer> convert2 = Integer::valueOf;
        int valor2 = convert2.convertir("3");
        System.out.println(valor2);
    }
}
