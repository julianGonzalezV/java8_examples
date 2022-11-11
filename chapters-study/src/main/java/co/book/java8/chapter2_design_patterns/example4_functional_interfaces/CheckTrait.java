package co.book.java8.chapter2_design_patterns.example4_functional_interfaces;

import co.book.java8.chapter2_design_patterns.example3.Animal;

/**
 * Forma manual de implementar el predicate
 */
@FunctionalInterface
public interface CheckTrait {
    public boolean test(Animal a);
}
