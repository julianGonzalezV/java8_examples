package co.book.java8.chapter1.virtual_method_invocation;

public class Bird extends Animal {
    @Override
    public void feed() {
        addSeed();
    }

    private void addSeed() { System.out.println("Bird is eating");}
}
