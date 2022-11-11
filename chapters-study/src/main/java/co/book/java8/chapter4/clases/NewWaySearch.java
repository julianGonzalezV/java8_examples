package co.book.java8.chapter4.clases;

import java.util.ArrayList;
import java.util.List;

public class NewWaySearch {


    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<Animal>(); // list of animals

        animals.add(new Animal("fish", false, true));

        animals.add(new Animal("kangaroo", true, false));

        animals.add(new Animal("rabbit", true, false));

        animals.add(new Animal("turtle", false, true));


        print(animals, a -> a.canSwim());
        //lo leo de la siguiente manera:
        //print es un método que recibe un listado y una implementación del trait CheckTrait
        // del segundo parametro YA LE ESTAMOS ENVIANDO DE ENTRADA LA implementación que se desea , por ejemplo para
        //swim se le dice al trait que debe tener una funcion que reciba un Animal a y devuelve un boolean y DICHO BOOLEAN SERa
        // EL A.CANsWIM

        // con la forma de TraditionalSearch.java hubieramos tenido que crear 2 clases que implementen de la interfcae

// pass class that does check

    }
 private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal))
            System.out.print(animal + " ");
        }

    }
}
