package co.book.chapter2_design_patterns.example4_functional_interfaces.Polymorphism;

public class Whale implements LivesInOcean {
    @Override
    public void makeSound() {
       System.out.println("sing");
    }
}
