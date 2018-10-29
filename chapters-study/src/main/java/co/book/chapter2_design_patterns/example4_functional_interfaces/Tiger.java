package co.book.chapter2_design_patterns.example4_functional_interfaces;

import co.book.chapter2_design_patterns.example3.Animal;

public class Tiger implements Sprint {
    @Override
    public void sprint(Animal animal) {
        System.out.println("Animal is sprinting fast! "+animal.toString());
    }
}
