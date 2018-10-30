package co.book.chapter2_design_patterns.example4_functional_interfaces;

import co.book.chapter2_design_patterns.example3.Animal;

public class FindMatchingAnimals {
     static void print(Animal animal, CheckTrait trait) {
        if (trait.test(animal))
            System.out.println(animal);
    }
}
