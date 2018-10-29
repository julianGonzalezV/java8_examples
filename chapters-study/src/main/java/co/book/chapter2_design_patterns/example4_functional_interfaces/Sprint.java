package co.book.chapter2_design_patterns.example4_functional_interfaces;

import co.book.chapter2_design_patterns.example3.Animal;

/**
 * La anotación no es requerida pero nos ayuda a asegurar que cuando alguien meta otro SAM falle
 * note como al meter sprint2 falla
 */
@FunctionalInterface
public interface Sprint {
    public void sprint(Animal animal);
    //public void sprint2(Animal animal);
}