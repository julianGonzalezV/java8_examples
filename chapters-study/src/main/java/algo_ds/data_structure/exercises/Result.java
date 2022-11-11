package algo_ds.data_structure.exercises;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Result {

    /*
     * Complete the 'customSort' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    /**
     * Explicación de la solución (debe correrlo en versiones de java8 en adelante)
     * > groupingBy se usa para agrupar el array de entrada, dando como resultado un Map
     * cuya clave sera el objeto que estoy iterando y el valor sera la frecuencia con que se
     * repite.
     * > Se hace uso de TreeMap para asegurar el ordenamiento automatico por el Key
     * > Dado que se requieren los elementos repetidos se usa ArrayList, quice usar TreeSet
     * para asegurar el orden pero elimina los repetidos
     * > Dado que arrayList no asegura el orden entonces se usa naturalOrder
     * > Se usa flatMap para aplanar la estructura que era Stream<Stream>
     *
     * @param arr
     */
    public static void customSort(List<Integer> arr) {
        System.out.println("Ordenando => "+ arr);
        Map<Integer, Integer> valueFrecuency = arr.stream().collect(groupingBy(x -> x, summingInt(x ->1)));
        Map <Integer, ArrayList<Integer>> frecuencyValue = new TreeMap<>();
        valueFrecuency.forEach((key,value)-> frecuencyValue.put(value, new ArrayList()));
        arr.forEach(x->frecuencyValue.get(valueFrecuency.get(x)).add(x));
        frecuencyValue.values().stream().forEach(x -> x.sort(Comparator.naturalOrder()));
        frecuencyValue.values().stream().flatMap(x->x.stream()).forEach(System.out::println);
    }



    public static void main(String ... agrs){
        customSort( Arrays.asList(5,3,1,2,2,4));
        customSort( Arrays.asList(5,3,1,1,2,2,4));
    }
}
