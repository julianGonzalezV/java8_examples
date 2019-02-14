package co.book.chapter7._7_concurrentCollections;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinAndRecursion {

    /**
     * Ojo esta es una versión barata que no es tail recursive (averigue en internet que es :) )
     * pero cumple de que es recursivo
     * @param n
     * @return
     */
    static int factorial(int n){
        System.out.println(n);
        if(n<=1)
            return 1;
        else{
            return n * factorial(n-1);
        }
    }

    /**
     *
     * @param weights
     */
    static void forkJoin(Double[] weights){
        ForkJoinTask<?> task = new WeighAnimalAction(weights,0,weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        // Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights).stream().forEach(
                d -> System.out.print(d.intValue()+" "));
    }

    /**
     *
     * @param args
     */
    public static void main(String ... args){
        System.out.println("factorial => "+factorial(5));

        System.out.println("FORK JOIN TASKS");
        forkJoin(new Double[10]);


    }

}

/**
 *
 */
class WeighAnimalAction extends RecursiveAction {
    private int start;

    private int end;
    private Double[] weights;
    public WeighAnimalAction(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }



    /**
     * Compute es un método heredado de RecursiveAction
     */
    @Override
    protected void compute() {
        if(end-start <= 3)
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: "+i);
            }
        else {
            int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            /**
             * invokeAll viene de la clase ForkJoinTask ya que RecursiveAction extends ForkJoinTask
             * pasndole 2 instancias cuando la cantidad de end-start es mayor que 3
             */
            invokeAll(new WeighAnimalAction(weights,start,middle),
                    new WeighAnimalAction(weights,middle,end));
        }
    }
}
