package co.book.chapter4.functional.interfaces;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by juligove on 2017/11/27.
 * Explicacion del FunctionType
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

        //Note que efectivamente es lo mismo que enviar la funcion stringSize0
        Function<String, Integer> stringSize0 = String::length;
        Integer value4 = nameMap.computeIfAbsent("vicente", stringSize0);

        System.out.println("FunctionType:::"+value);
        System.out.println("FunctionType:::"+value2);
        System.out.println("FunctionType:::"+value3);
        System.out.println("FunctionType:::"+value4);



        //The Function interface has also a default compose method
        //Componer varios functions

        Map<String, String> nameMap2 = new HashMap<>();
        nameMap2.put("julian", "GONZALEZ");
        Function<String, Integer> stringSize = s -> s.length();
        Function<Integer, String> intToStr = s -> String.format("El key es de tamaño %s",s);

        //componiendo funciones
        Function<String, String> composedFunc = intToStr.compose(stringSize);
        String val5 = nameMap2.computeIfAbsent("vicente", composedFunc);
        //computeIfAbsent requiere un function tal que sea compatible con el Key y el Value del Map
        String val6 = nameMap2.computeIfAbsent("julian", composedFunc);
        System.out.println(val5);
        System.out.println(val6);



        //Primitive Function Specializations
        //existen varias como IntFunction, LongFunction, DoubleFunction
        //1) IntFunction
        IntFunction if1 = x-> String.format("esto es un string con el valor %s", x);
        String[] str1 = (String[]) IntStream.range(0, 5).mapToObj(if1).toArray(String[]::new);
        Stream.of(str1).forEach(System.out::println);

        //DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction
        //1) DoubleToIntFunction, al ir a la documentacion es facil porque dicque que recibe un double y retorna un int
        DoubleToIntFunction dintf1 = x-> (int) Math.ceil(x);
        System.out.println(dintf1.applyAsInt(1.2));
        ;
        Stream.of(2.1, 3.4, 4.0).map(dintf1::applyAsInt).forEach(System.out::println);
    }
}
