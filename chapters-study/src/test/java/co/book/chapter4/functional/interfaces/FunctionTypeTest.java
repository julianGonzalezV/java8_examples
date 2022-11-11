package co.book.chapter4.functional.interfaces;

import co.book.java8.chapter4.functional.interfaces.FunctionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class FunctionTypeTest {

    @Test
    @DisplayName("Someke Test")
    void testHelloWorld(){
        assertEquals(2, 1 + 1);
    }

    @Test
    @DisplayName("El valor de un key existente se retorna correctamente")
    /**
     * computeIfAbsent recibe la clave a buscar y si no existe aplica
     * la funcion (segundo argumento)
     * Note como el argumento de entrada es un lambda
     *
     */
    void mapNameToIntTest1(){
        int result = FunctionType.mapNameToInt(s -> s.length(), "julian");
        assertThat(result, is(30));

    }



    @Test
    @DisplayName("El valor de un key existente se retorna correctamente")
    /**
     * aplicando method reference los :: este reference es del tipo
     * Class::method
     *
     */
    void mapNameToIntTest2(){
        int result = FunctionType.mapNameToInt(String::length, "vicente");
        assertThat(result, is(7));

    }


    @Test
    @DisplayName("Un function permite composicion de otras funciones tipo Function")
    /**
     *
     */
    void composedFunc(){
        Function<String, Integer> stringSize = s -> s.length();
        Function<Integer, String> intToStr = s -> String.format("El key es de tamaño %s",s);
        //componiendo funciones
        Function<String, String> composedFunc = intToStr.compose(stringSize);
        String  result =FunctionType.strToStr(composedFunc, "vicente");
        assertThat(result, is("El key es de tamaño 7"));

    }


    @Test
    @DisplayName("Un function permite composicion de otras funciones tipo Function")
    /**
     * Existen varias Primitive Function Specializations como IntFunction, LongFunction, DoubleFunction
     * IntFunction
     */
    void intFunctionCase1(){
        List<String> result =FunctionType.intFunctionStrCase(x-> String.format("esto es un string con el valor %s", x),5);
        assertThat(result.get(4), is("esto es un string con el valor 4"));

    }


    @Test
    @DisplayName("Ejemplo de DoubleToIntFunction")
    void doubleToIntFunctionCase1(){
        double[] input = {2.1, 3.4, 4.0};
        List<Integer> result =FunctionType.doubleToIntFunction(x-> (int) Math.ceil(x),input);
        assertThat(result.get(1), is(4));

    }

    @Test
    @DisplayName("Two-Arity Function Specializations ----> BiFunction")
    void biFunctionCase(){
        assert false;
    }

    @Test
    @DisplayName("Two-Arity Function Specializations ----> supplier")
    void suppliersCase(){
        assert false;
    }


    @Test
    @DisplayName("Two-Arity Function Specializations ----> consumer")
    void consumerCase(){
        assert false;
    }

}
