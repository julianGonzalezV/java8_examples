package co.book.chapter7._8_Liveness;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * reornará
 * pool-1-thread-1 Got Food!
 pool-1-thread-2 Got Water!
 ambos threads se quedarán bloqueados

 */
public class Deadlock {

    public static void main(String[] args) {
        // Create participants and resources
        Fox foxy = new Fox();
        Fox tails = new Fox();
        Food food = new Food();
        Water water = new Water();
        // Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food,water));
            service.submit(() -> tails.drinkAndEat(food,water));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}


/**
 * Cual es el problema??
 * dado que move() se llama en ambos lados entonces cuando el Hilo-1 termina de hacer food
 * se queda esperando para pasarse a getWater ES EN ESE INSTANTE en que hay bloqueo,
 * pues el Hilo-2 termina getWater y va por food y al ver que Supuestamente no ha terminado espera a que se libere el recurso
 * pero Hilo1 necesita water y ve que Hilo-2 Supuestamente no ha terminado
 * y
 */
class Fox {

    /**
     *
     * @param food
     * @param water
     */
    public void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.println(Thread.currentThread().getName()+"Got Food!");
            move();
            synchronized (water) {
                System.out.println(Thread.currentThread().getName()+"Got Water!");
            }
        }
    }

    public void drinkAndEat(Food food, Water water) {
        synchronized(water) {
            System.out.println(Thread.currentThread().getName()+"Got Water!");
            move();
            synchronized(food) {System.out.println(Thread.currentThread().getName()+"Got Food!");
            }
        }
    }

    public void move() {
        try {
            /**
             * Entre mayor sea el número, mayor tiempo esperará el hilo actual
             */
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle exception
        }
    }


}

class Food{

}

class Water{

}
