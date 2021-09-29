package co.book.chapter1.virtual_method_invocation;

import java.util.Objects;

public class Lion extends Animal {
    String name = "Leonidas";

    @Override
    public void feed() {
        addMeat();
    }

    private void addMeat() {
        System.out.println("Lio is eating");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lion lion = (Lion) o;
        return name.equals(lion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
