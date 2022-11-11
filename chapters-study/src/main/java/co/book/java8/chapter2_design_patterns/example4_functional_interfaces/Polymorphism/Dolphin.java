package co.book.java8.chapter2_design_patterns.example4_functional_interfaces.Polymorphism;

public class Dolphin implements LivesInOcean {
    @Override
    public void makeSound() {
        System.out.println("whistle");
    }
}
