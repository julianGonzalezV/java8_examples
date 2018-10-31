package co.book.chapter2_design_patterns.creational_patterns.a_singleton;

/**
 * Forma de crear #2 using a static block
 */
// Instantiation using a static block when the class is loades
public class StaffRegister {
    private static final StaffRegister instance;

    //Instantiation using a static block
    static {
        instance = new StaffRegister();
        // Perform additional steps
        /**
         * ESTO ES lo clave que acá adentro podemos realiza mas acciones
         */
    }

    private StaffRegister() {
    }

    public static StaffRegister getInstance() {
        return instance;
    }

    // Data access methods
    //............
    //............
}


