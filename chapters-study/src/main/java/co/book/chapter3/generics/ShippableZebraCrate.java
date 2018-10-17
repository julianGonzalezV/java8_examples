package co.book.chapter3.generics;

/**
 * 1ra opción para implementar Shippable (Clase concreta)
 * Interface que solo envía cebras
 */
public class ShippableZebraCrate implements Shippable<Zebra> {
    @Override
    public void ship(Zebra zebra) {

    }
}

/**
 * 2da opción para implementar Shippable (generic class.)
 * @param <U>
 */
class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) { }
}

/**
 * Forma antes de java6, pero no se recomienda
 */
class ShippableCrate implements Shippable {
    public void ship(Object t) { }
}