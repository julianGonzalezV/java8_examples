package co.book.java8.chapter2_design_patterns.example4_functional_interfaces;

import co.book.java8.chapter2_design_patterns.example3.Animal;

public interface SprintFaster extends Sprint {
    public void sprint(Animal animal);
}
