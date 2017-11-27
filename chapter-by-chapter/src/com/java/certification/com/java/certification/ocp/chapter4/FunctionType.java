package com.java.certification.com.java.certification.ocp.chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by juligove on 2017/11/27.
 */
public class FunctionType {
    public static void  main(String... args){
        // Function es una interface definida así:
        //public interface Function<T, R> ------>  R apply(T t);
        //apply sería el metodo que se ejecutaría.
        //El siguiente map es de clave tipo Str y valor tipo Int
        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put("julian", 30);
        //computeIfAbsent recibe la clave a buscar y si no existe aplica
        //la funcion (segundo argumento)
        Integer value = nameMap.computeIfAbsent("julian", s -> s.length());

        //jhon no existe entonces aplicará la funcion
        Integer value2 = nameMap.computeIfAbsent("jhon", s -> s.length());

        //aplicando method reference los :: este reference es del tipo
        // Class::method
        Integer value3 = nameMap.computeIfAbsent("vicente", String::length);

        System.out.println("FunctionType:::"+value);
        System.out.println("FunctionType:::"+value2);
        System.out.println("FunctionType:::"+value3);



        //The Function interface has also a default compose method
        //Componer varios functions

        Function<String, Integer> stringSize = s -> s.length();
        Function<Integer, String> stringCompose = s -> String.format("El key es de tamaño %s",s);
        String compose1 = nameMap.computeIfAbsent("vicente", stringSize.compose(stringCompose));
    }
}
