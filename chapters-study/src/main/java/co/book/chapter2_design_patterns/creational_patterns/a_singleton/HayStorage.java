package co.book.chapter2_design_patterns.creational_patterns.a_singleton;

/**
 * the singleton class is effectively final, es decir qu eimplicitamente al hacerla
 * private de su constructor no es posible crear una subclase o usarla desde otras clases con new
 *
 *
 * Forma de crear #1 directly in the definition of the instance reference. (line 22)
 *
 *
 */
public class HayStorage {
    private int quantity = 0;

    /**
     * Private para evitar que desde otros lados puedan hacer new para crear instancias de la clase
     */
    private HayStorage() {
    }

    /**
     * singletons se crean como private static
     */
    private static final HayStorage instance = new HayStorage();

    /**
     * Singletons se acceden via public static, porque no se puede crear instancia en otras partes sino
     * @return
     */
    public static HayStorage getInstance() {
        return instance;
    }

    /**
     * synchronized para eviater que 2 o mas procesos correan el mismo método al mismo tiempo
     *  RECORDAR QUE EN LA LITERATURA ESO ES CONSIDERADO BLOQUEANTE
     * @param amount
     */

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount) return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity() {
        return quantity;
    }
}
