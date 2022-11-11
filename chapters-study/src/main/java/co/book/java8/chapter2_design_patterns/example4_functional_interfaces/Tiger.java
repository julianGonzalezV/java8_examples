package co.book.java8.chapter2_design_patterns.example4_functional_interfaces;

import co.book.java8.chapter2_design_patterns.example3.Animal;

public class Tiger implements Sprint {
    @Override
    public void sprint(Animal animal) {
        System.out.println("Tiger is sprinting fast! "+animal.toString());
    }
}
