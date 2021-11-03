package co.book.chapter3.comparable;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * If your class implements Comparable , it can be used in these data structures that require
 comparison
 *The Comparable interface has only one method
 * public int compareTo(T o): note como aplican generics, evitando asi validaciones de tipo
 * haciendo casting
 */
public class DuckComparable implements Comparable<DuckComparable> {

    private String name;

    public DuckComparable(String name){
        this.name = name;
    }

    /**
     * Para que cuando hagamos print del objeto sea legible
     * @return
     */
    public String toString() {
        return name;
    }


    @Override
    public int compareTo(DuckComparable o) {
        //return 0;
        //si tuviera el atributo Id y entero entonce sseria
        //return return id – o.id;
        return name.compareTo(o.name);//si son iguales retorna 0 sino un valor entero positivo cuando el objeto
        //actual es mas grande que contra el que se compara , o <0 si es menor
    }



    public static void main(String[] args) {
        List<DuckComparable> ducks = new ArrayList<>();
        ducks.add(new DuckComparable("Quack"));
        ducks.add(new DuckComparable("Puddles"));
        Collections.sort(ducks);
        System.out.println(ducks);// [Puddles, Quack], note como ordena por nombre
    }
}
