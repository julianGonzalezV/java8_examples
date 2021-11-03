package co.book.chapter4.functional.interfaces;

import java.util.*;
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

    /**
     * Function es una interface definida asi:
     *public interface Function<T, R> ------>  R apply(T t);
     *apply seria el metodo que se ejecutaria.
     *El siguiente map es de clave tipo Str y valor tipo Int
     * @return
     */
    public static int mapNameToInt(Function<String, Integer> functionT, String valIfAbsent){
        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put("julian", 30);
        return nameMap.computeIfAbsent(valIfAbsent, functionT);
    }


    /**
     *
     * @param functionT
     * @param valIfAbsent
     * @return
     */
    public static String strToStr(Function<String, String> functionT, String valIfAbsent){
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("julian", "GONZALEZ");
        return nameMap.computeIfAbsent(valIfAbsent, functionT);
    }


    /**
     *
     * @param intFunctionT
     * @param lasTVal
     * @return
     */
    public static List<String> intFunctionStrCase(IntFunction<String> intFunctionT, int lasTVal){
        Map<String, String> nameMap = new HashMap<>();
        return IntStream.rangeClosed(0, lasTVal).mapToObj(intFunctionT).collect(toList());
    }




    /**
     * DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction
     * DoubleToIntFunction, al ir a la documentacion es facil porque dicque que recibe un double y retorna un int
     * @param dintf
     * @param vals
     * @return
     */
    public static List<Integer> doubleToIntFunction(DoubleToIntFunction dintf, double[]  vals){
        return Arrays.stream(vals).mapToObj(dintf::applyAsInt).collect(toList());
    }
}
