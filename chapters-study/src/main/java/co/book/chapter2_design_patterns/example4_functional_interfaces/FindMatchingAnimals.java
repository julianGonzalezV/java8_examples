package co.book.chapter2_design_patterns.example4_functional_interfaces;

import co.book.chapter2_design_patterns.example3.Animal;

import java.util.function.Predicate;

public class FindMatchingAnimals {
     static void print(Animal animal, CheckTrait trait) {
        if (trait.test(animal))
            System.out.println(animal);
    }

    /**
     * Haciendo uso de Predicate, así no tenemos que crear interfaces que reciban un parametro y devuelvan un boolean o
     * sin que hacemos uso de lo que ya existe
     * @param animal
     * @param trait
     */
    static void print2(Animal animal, Predicate<Animal> trait) {
        if (trait.test(animal))
            System.out.println(animal);
    }
}
