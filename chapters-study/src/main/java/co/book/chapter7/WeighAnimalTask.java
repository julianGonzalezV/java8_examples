package co.book.chapter7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class WeighAnimalTask extends RecursiveTask<Double> {
    private int start;
    private int end;
    private Double[] weights;
    public WeighAnimalTask(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }
    protected Double compute() {
        if(end-start <= 3) {
            double sum = 0;
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start+((end-start)/2);
            RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
            otherTask.fork();
            //make sure you call fork before de current(en este caso otherTask) thread begins (compute)
            //fork es lo mismo que submit en thread executor
            return new WeighAnimalTask(weights,middle,end).compute() + otherTask.join();
            //jpin caus que el hilo actual espere por el resultado de la subtarea
            //make sure you call join after fork (ojo no otherTask.fork().join() porque va a causar
            // que everything se ejecute en en el mismo hilo )
        }
    }


    //Liveness: Es la habilidad que un sistema tiene en ejecutarse en un tiempo oportuno.

    //por lo anterior existen Liveness Issues como los son deadlock, starvation, and livelock.

    public static void main(String[] args) {
        Double[] weights = new Double[10];
        //note qye la diferencia entre las clases abstractas RecursiveTask y RecursiveAction
        //radica en que la primera retorna un valor, por lo tanto mire como se obtuvo el total
        // de la suma de cada elemento computado por los hilos
        ForkJoinTask<Double> task = new WeighAnimalTask(weights,0,weights.length);

        ForkJoinPool pool  = new ForkJoinPool();
        Double result = pool.invoke(task);
        System.out.println("Weights sum: "+result);
        Arrays.asList(weights).stream().forEach(
                d -> System.out.print(d.intValue()+" "));
    }
}