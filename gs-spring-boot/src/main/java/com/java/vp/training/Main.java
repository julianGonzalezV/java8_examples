package com.java.vp.training;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("eoooooooooo");
        final int uno = 1;
        IntStream.range(1, 10).filter(x-> {
            int dos = uno + 2;
            return x> 5;
        }).forEach(System.out::println);


       // Desventaja de imperativo es la cantidad de código y muchas veces la NO protección del estado

        // declarativo comandos de alto nivel
        //lo de :: en java8 se conoce como declaracion metódica
        //ejemplo el metodo generate de IntStreams solicita una funcion y con los :: hago que se le pase el metodo sin
        //ejecutarlo lazy val

        //funcion o comando finalizador
        //el ejemplo muestra una lista de numeros y por cada uno aplica generate luego limit y luego sum , sum
        //en este caso sería la finalizadora



        //filter solicita un predicate
        //un predicate es una funcion que solicita un argumento y devuelve un booleano
        //el filter CUANDO una variable no cumple no sigue

        //un stream esta preparado para computacio paralela

        //SPRING BOOT

        //@RESTCONTROLLER érmite levantar un servicio

        //suppliers no reciben parámetros pero si devuelve un valor

        //estudiar spring boot

        //collect permite definir funciones que trasnformen el resultado que deseee
        //VER COLLECT examples
        //


        //flatMap : es como tener una colección de colecciones



        //Sección2:::::::::::::::::::::..2017-11-20:::::::::::::::::::::::::::::

        //de clases interfaces anónimas a sam lambda

        //spring shell permite añadir una linea de comandos
    }
}
