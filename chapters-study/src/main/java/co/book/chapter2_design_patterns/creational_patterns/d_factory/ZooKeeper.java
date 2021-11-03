package co.book.chapter2_design_patterns.creational_patterns.d_factory;

public class ZooKeeper {
    public static void main(String[] args) {
        /**
         * Aca hay loss coupling porque Zookeper no tiene que saber mayor cosa de la clase fish por  ejemplo
         * sino que pide una instancia pasando un string.
         */
        final Food food = FoodFactory.getFood("polar bear");
        food.consumed();
    }
}
