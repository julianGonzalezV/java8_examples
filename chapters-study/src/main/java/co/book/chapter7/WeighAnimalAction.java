package co.book.chapter7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class WeighAnimalAction extends RecursiveAction {
    private int start;
    private int end;
    private Double[] weights;
    public WeighAnimalAction(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }
    protected void compute() {
        if(end-start <= 3)
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: "+i);
            }
        else {
            int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            //note el llamado recursivo Y haciendo uso de split and conquer
            invokeAll(new WeighAnimalAction(weights,start,middle),
                    new WeighAnimalAction(weights,middle,end));
        }
    }


    public static void main(String[] args) {
        Double[] weights = new Double[10];
        //ForkJoin aplica para quellos escenarios en los que se tengan varias tareas a realizar
        //y se quieran dividir en sub-tareas (split and conquer).
        //cada subtarea abre un hilo diferente Ojo si tengo 10 subtareas y 4 hilos el sistema
        //espera hasta que se vayan liberando

        ForkJoinTask<?> task = new WeighAnimalAction(weights,0,weights.length);
        //ForkJoinPool por defecto verifica los números de procesadores de la maquina
        // para saber cuantos hilos iniciar
        ForkJoinPool pool  = new ForkJoinPool();
        pool.invoke(task);
// Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights).stream().forEach(
                d -> System.out.print(d.intValue()+" "));
    }
}
