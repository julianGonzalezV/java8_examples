package co.book.exercises;

import java.util.*;

public class example1 {

    /**
     * Metodo para contar los elementos que están repetidos en la lista de
     * entrada input
     * @return
     */
    public static int example1(List<Integer> inputList){
        System.out.println("example1 Input  => "+inputList);
        /**
         * Por qué Set? R/ Porque ofrece el método add que retorna
         * si el elemento ya existía o no
         *
         */
        Set<Integer> set = new HashSet<>();
        int counter = 0;
        /*
        La funcion add del set retorna un booleano donde
        true: Si el elemento se insertó correctamente, dado que no existía
        false: contrario a lo anterior
         */
        for (Integer i: inputList ) {
            if(!set.add(i)){
                counter++;
            }
        }
        System.out.println("example1 Result => "+ set );

        System.out.println("example1 Result => "+ counter );
        return counter;
    }


    /**
     * Método que retorna un Map en donde el key es igual al elemento en la lista de entrada
     * y el value es la cantidad de veces que se repite el mismo elemento en la
     * lista de entrada
     * @param strList
     * @return
     */
    public static  Map<String, Integer> example2(  List<String> strList){
        System.out.println("example2 Input  => "+strList);
        /**
         * POr que treeMao?
         *
         */
        Map<String, Integer> map = new TreeMap<>();
        for (String i: strList ) {
            /*
             Note como la operacio put devuelve null si el Key no existía
             de lo contrario devuelve el valor del Key antes de ser actualizado
             */
            if(map.put(i, 1)!=null) map.replace(i, map.get(i)+1);
        }
        System.out.println("example2 Result => "+map);
        return map;
    }


    public static void main(String[] args) {
        example1( Arrays.asList(10, 2, 10, 7, 5, 2, 9, 7, 8, 11,11, 12, 13, 14));
        example2( Arrays.asList("a,b,c,a,d,e,b,f,g".split(",")));

        /**
         * hACER LO MISMO PERO FUNCION AL:) :) :)
         */

    }
}
