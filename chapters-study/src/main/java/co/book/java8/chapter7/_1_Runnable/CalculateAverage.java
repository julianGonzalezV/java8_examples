package co.book.java8.chapter7._1_Runnable;


/**
 * runnable es una interfaz
 *
 * @FunctionalInterface public interface Runnable {
void run();
}

 debemos implemenar el run
 Lo que permite runnable es ejecutar una tarea en un hilo que es definido por el usuario

 */
public class CalculateAverage implements Runnable {

    private double[] scores;

    /**
     * Se pueden pasar argumentos para que se puedan usan en el metodo run()
     * @param scores
     */
    public CalculateAverage(double[] scores) {
        this.scores = scores;
    }

    @Override
    public void run() {
        // Define work here
        // puede usar el atributo scores aca
    }
}
