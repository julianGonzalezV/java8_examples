package co.book.java8.chapter2_design_patterns.example4_functional_interfaces;

@FunctionalInterface
public interface Run extends Sprint {
    /**
     * Como es de entender sigue siendo single abstract method  SAM
     * porque hace extends Sprint
     */
}
