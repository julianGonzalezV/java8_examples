package co.book.chapter1.virtual_method_invocation;

public class Cow extends Animal {
    @Override
    public void feed() {
        addHay();
    }

    private void addHay() { System.out.println("Cow is eating");}
}
