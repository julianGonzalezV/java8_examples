package com.java.certification.com.java.certification.ocp.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamMain {

    //NOTA LLEVAR ESTOS CASOS QUE TEST DE PRUEBAS PARA EJEMPLIFICARLOS MEJOR

    public static void  main(String... args){

        //example1, ejemplo de streams infinitos, llamar count en uno de estos se queda forever count
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

        //finitos
        Stream<Integer> ex1 = Stream.of(1,2,3,4,5);
        Stream<Integer> ex2 = ex1.map(x -> x + 2);
        Optional<Integer> min1 = ex2.min((s1, s2)-> s1 - s2);
        min1.ifPresent(System.out::println); // ape

        //using count
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");// 3
        //System.out.println(s.count()); AL APLICAR UN METODO CMO ESTE Que sería un terminal operartor el stream de
        // esfuma y no puede volver a ser usado


        Stream<String> str = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = str.min((s1, s2)-> s1.length() - s2.length());
        min.ifPresent(System.out::println); // ape



        //findAny() and findFirst()
        Stream<String> infinite = Stream.generate(() -> "chimp");
        s.findAny().ifPresent(System.out::println); // monkey
        infinite.findAny().ifPresent(System.out::println); // chimp


        //allMatch() , anyMatch() and noneMatch()
        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred)); // true


    }

}
