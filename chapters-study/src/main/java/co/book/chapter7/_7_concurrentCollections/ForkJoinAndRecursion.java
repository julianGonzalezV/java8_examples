package co.book.chapter7._7_concurrentCollections;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

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
     * @param weights: Note como en el primer llamado weigths es un array con puros ceros.,
     *               no hay pesos caculados o realizados
     */
    static void forkJoin(Double[] weights){
        System.out.println("Animales que se deben pesar: "+weights.length);
        ForkJoinTask<?> task = new WeighAnimalAction(weights,0,weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        // Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights).stream().forEach(
                d -> System.out.print(d.intValue()+" "));
    }

    static void forkJoinCarrryingValue(Double[] weights){

        System.out.println("forkJoinCarrryingValue Animales que se deben pesar: "+weights.length);
        //el double dentro del diamante indica que  la tarea retorna este tipo de dato
        ForkJoinTask<Double> task = new WeighAnimalActionCarryingAResult(weights,0,weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        /**
         * por la definicioa de ForkJoinTask<Double>, no es necesario hacer casting aca de
         * (Double)pool.invoke(task) porque ya se infiere, quite el Double de ForkJoinTask<Double>, y
         * notaraque le pide casting

         */
        Double result = pool.invoke(task);
        // Print results
        System.out.println();
        System.out.print("Weights Sum: "+result);
    }

    /**
     *
     * @param args
     */
    public static void main(String ... args){
        //System.out.println("factorial => "+factorial(5));

        System.out.println("FORK JOIN TASKS");
        forkJoin(new Double[10]);
        /** El anterior va a imprimir
         * FORK JOIN TASKS
         * Animales que se deben pesar: 10
         [start=0,middle=5,end=10]
         [start=0,middle=2,end=5]
         Animal Weighed: 0
         Animal Weighed: 2
         Animal Weighed: 1
         [start=5,middle=7,end=10]
         Animal Weighed: 5
         Animal Weighed: 3
         Animal Weighed: 4
         Animal Weighed: 6
         Animal Weighed: 7
         Animal Weighed: 8
         Animal Weighed: 9
         */

        forkJoinCarrryingValue(new Double[10]);


    }

}

/**
 * Versoin que hace uso del método cmpute de la clase RecursiveAction o mas bien de fork jpin
 * que es la que hereda RecursiveAction
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
        /**
         * desde start hasta end, siendo ambos el # del worker a realizar la tarea,
         * en este caso pesar los animales :)
         */
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("start:"+start+", end:"+end+" Animal Weighed: "+i);
            }
        else {
            int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            /**
             * invokeAll viene de la clase ForkJoinTask ya que RecursiveAction extends ForkJoinTask
             * pasandole 2 instancias cuando la cantidad de end-start es mayor que 3
             * Note el llamado recursivo pues se ejecutara el método WeighAnimalAction.compute
             * en cada división
             */
            invokeAll(new WeighAnimalAction(weights,start,middle),
                    new WeighAnimalAction(weights,middle,end));
        }
    }
}



/**
 * Versión que hace uso del método compute de la clase RecursiveTask que a diferencia de RecursiveAction
 * lo que hace es que el compute devuelve un valor! , suponga que desea saber la suma de todos los
 * pesaje de animales en el zoologico
 */
class WeighAnimalActionCarryingAResult extends RecursiveTask {
    private int start;

    private int end;
    private Double[] weights;
    public WeighAnimalActionCarryingAResult(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }



    /**
     * Compute es un método heredado de RecursiveAction
     */
    @Override
    protected Double compute() {
        if(end-start <= 3){
            // se crea nueva variable suma que llevara la suma de todos los pesos
            double suma = 0;
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("start:"+start+", end:"+end+" Animal Weighed: "+i);
                suma+=weights[i];
            }
            return suma;
        }

        else {
            int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            RecursiveTask<Double> otherTask = new WeighAnimalActionCarryingAResult(weights,start,middle);
            otherTask.fork();
            return new WeighAnimalActionCarryingAResult(weights,middle,end).compute() + otherTask.join();
        }
    }
}
