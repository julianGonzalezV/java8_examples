package co.book.chapter2_design_patterns.creational_patterns.a_singleton;

/**
 * Forma de crear un singleton #3 Lazy Instantiation to Singletons
 * delay creation of the singleton until the first time the
 getInstance() method is called:
 */
public class VisitorTicketTracker {

    private static VisitorTicketTracker instance;
    private VisitorTicketTracker() {
    }

    /**
     * Lazy instantiation reduces memory usage
     * improves performance when an application
     starts up: POr fin ENTIENDO ALGO IMPORTANTE DEL LAZY instantiation

     DOWNSIDE :( :
     the users may see a noticeable delay the first time a particular type of resource is needed.

     * @return
     */
    public static VisitorTicketTracker getInstance() {
        if(instance == null) {
            instance = new VisitorTicketTracker(); // NOT THREAD-SAFE!
            /**
             * Por que NO ES  THREAD-SAFE??
             * 1) En la linea 10 no es final como si lo hace HayStorage : private static final HayStorage instance = new HayStorage();
             * por lo cual se crea una vez se cargue la clase y no es posible modificarse, here NO ES FINAL PRECISAMENTE POR E
             * VALIDACION de si es null entoncdes retorne un new
             *
             * 2) Imagine 2 hilos accediendo a la misma vez y solicitando getInstance, pues se crearan 2 a la misma vez
             * y todo lo que pase de alli en adelante es inseguro a nivel de concurrencia
             *
             * SOLUCIÓN A LO ANTERIOR ES
             *public static synchronized VisitorTicketTracker getInstance(){...
             *
             *
             *
             *
             * UNA MEJOR SOLUCION ES: DELETING DoubleChecked Locking
             *
             * RECUERDE:
             * Thread safety is the property of an object that guarantees safe execution by multiple
             threads at the same time.
             */
        }
        return instance;
    }

    /**
     * Solución con bad performance ante concurrencia
     * @return
     */
    public static synchronized VisitorTicketTracker getInstance1() {
        if(instance == null) {
            synchronized(VisitorTicketTracker.class) {
                if(instance == null) {
                    instance = new VisitorTicketTracker();
                }
            }
        }
        return instance;
    }



    /**
     * eL ANTERIOR CON synchronized1 es SUPER BLOQUEANTE ya que siemre que se solicite una instancia va a
     * tener que esperar, cuando REALMENTE ESA ESPERA DEBIÓ SER LA PRIMERA VEZ PORQUE COMO ES SINGLETON UNA VEZ
     * SE CREE YA SE CUENTA CON LA INSTANCIA
     * volatile LO QUE hace es prevents a subtle case where the compiler tries to optimize the code such that
     that the object is accessed before it is finished being constructed.
     * @return
     */
    private static volatile VisitorTicketTracker instance2;
    public static VisitorTicketTracker getInstance2() {
        if(instance2 == null) {
            synchronized(VisitorTicketTracker.class) {
                if(instance2 == null) {
                    instance2 = new VisitorTicketTracker();
                }
            }
        }
        return instance2;
    }
    // Data access methods synchronized
    // ..............
    // ...........

}
