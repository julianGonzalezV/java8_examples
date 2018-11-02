package co.book.chapter1.virtual_method_invocation;

public class Lion extends Animal {
    String name = "Leonidas";

    @Override
    public void feed() {
        addMeat();
    }

    private void addMeat() {
        System.out.println("Lio is eating");
    }
}
