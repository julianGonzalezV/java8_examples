package co.book.java8.chapter3.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Duck implements Comparable<Duck> {

    private String name;
    private int weight;

    /**
     * Constructor
     * @param name
     * @param weight
     */
    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }


    public int getWeight() { return weight; }
    public String getName() { return name; }
    public String toString() { return name; }

    @Override
    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }




    public static void main(String[] args) {
        Comparator<Duck> byWeight = new Comparator<Duck>() {
            public int compare(Duck d1, Duck d2) {
                return  d1.getWeight() - d2.getWeight();
            }
        };
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks);// [Puddles, Quack] //orden alfabético
        Collections.sort(ducks, byWeight);
        System.out.println(ducks);// [Quack, Puddles] Orden por peso , al ser numéri


        /**
         * Otras formas de crear el comparator
         */


        Comparator<Duck> byWeight2 = (Duck d1, Duck d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Duck> byWeight3 = (d1, d2) -> { return d1.getWeight() - d2.getWeight(); };
        Comparator<Duck> byWeight4 = (Duck d1, Duck d2) -> {return d1.getWeight() - d2.getWeight(); };
        Comparator<Duck> byWeight1 = (d1, d2) -> d1.getWeight() - d2.getWeight();//lambda
        Comparator<Duck> byWeight5 = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
        Comparator<Duck> byWeight6 = DuckHelper::compareByWeight;
        /** lo anterior dice es eyy sabemos que comparator necesita que se le implemente el compare(d1, d2)
         * que recibe dos parametrros y retorna un entero (esa es su firma), ahora que habra en DuckHelper
         * que cumpla con la firma......R/ pues el compareByWeight
         *
         * OJO LA SITAXIS xxx::yyy lo que retorna es lafunción yyy() y no el retorno de la funcion yyy(),
         * es decir que aplica el deferred execution
                */

        Comparator<Duck> byWeight7 = DuckHelper::compareByName; // las misma descripción de arriba




    }

}
