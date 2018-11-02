package co.book.chapter1.virtual_method_invocation;

public abstract class Animal {
    String name = "???";

    public abstract void feed();

    public void printName() {
        System.out.println(name);
    }
}
