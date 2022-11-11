package co.book.java8.chapter2_design_patterns.example4_functional_interfaces.Polymorphism;

public class Lemur extends Primate implements HasTail{

    public int age = 10;

    @Override
    public boolean isTailStriped() {
        return false;
    }


}
