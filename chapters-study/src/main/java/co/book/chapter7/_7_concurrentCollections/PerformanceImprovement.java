package co.book.chapter7._7_concurrentCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PerformanceImprovement {
    public static void main(String[] args) {
        System.out.println("WhaleDataCalculator");

        WhaleDataCalculator calculator = new WhaleDataCalculator();
        // Define the data
        List<Integer> data = new ArrayList<Integer>();
        for(int i=0; i<500; i++) data.add(i);

        System.out.println(":::::::::::::::::::::SERIAL");
        long start = System.currentTimeMillis();
        calculator.processAllDataSerialWay(data);
        double time = (System.currentTimeMillis() - start)/1000.0;
        // Report results
        System.out.println("\n Serial Tasks completed in: "+time+" seconds");

        System.out.println(":::::::::::::::::::::PARALLEL");
        long start2 = System.currentTimeMillis();
        calculator.processAllDataInParallel(data);
        double time2 = (System.currentTimeMillis() - start2)/1000.0;
        // Report results
        System.out.println("\nParallel Tasks completed in: "+time2+" seconds");//MUCHO MEJOR NO? :)


        /**
         *
         */
        List<String> dataStrToMayus = new ArrayList<String>();
        for(int i=0; i<500; i++) dataStrToMayus.add("cadenaNo=>"+i);
        long start3 = System.currentTimeMillis();
        calculator.lowerToUpperParallel(dataStrToMayus);
        double time3 = (System.currentTimeMillis() - start3)/1000.0;

    }

}


 class WhaleDataCalculator {

    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        // Handle interrupted exception
        }
        return input+1;
    }

     public String toUpperCaseSleep(String input) {
         try {
             Thread.sleep(10);
         } catch (InterruptedException e) {
             // Handle interrupted exception
         }
         return input.toUpperCase();
     }

    public void processAllDataSerialWay(List<Integer> data) {
        long conteo = data.stream().map(a -> processRecord(a)).count();
        System.out.println("conteo=> "+conteo);
    }

     /**
      * Note como por el solo hecho de cambiar a parallelStream
      * el performace mejora!
      *
      * Muy util para operaciones independienets!!!
      * OJO Para tamanio pequeños de datos quizás ni se note la mejora
      * y no todo Stream debe computarse paralelamente
      *
      * @param data
      */
     public void processAllDataInParallel(List<Integer> data) {
         Stream st = data.parallelStream().map(a -> processRecord(a));
         Stream st2 = st;
         /*Stream st3 = st2.limit(10);
         st3.forEach(System.out::print);
         System.out.println();*/
         System.out.println("conteo=> "+st2.count());
     }


     /**
      * Note que este proceso en paralelo no requiere que se convierta el string anterior para convertir el
      * siguiente, por eso esta tarea es INDEPENDIENTE
      * @param data
      */
     public void lowerToUpperParallel(List<String> data){
         data.parallelStream().map(x -> {
             System.out.println(x);
             return toUpperCaseSleep(x);
         }).forEach(System.out::println);
     }


}


