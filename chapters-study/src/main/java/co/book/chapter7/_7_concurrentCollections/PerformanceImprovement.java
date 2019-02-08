package co.book.chapter7._7_concurrentCollections;

import java.util.ArrayList;
import java.util.List;

public class PerformanceImprovement {
    public static void main(String[] args) {
        System.out.println("WhaleDataCalculator");

        WhaleDataCalculator calculator = new WhaleDataCalculator();
        // Define the data
        List<Integer> data = new ArrayList<Integer>();
        for(int i=0; i<1000; i++) data.add(i);

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
        System.out.println("\nParallel Tasks completed in: "+time2+" seconds");



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

    public void processAllDataSerialWay(List<Integer> data) {
        long conteo = data.stream().map(a -> processRecord(a)).count();
        System.out.println("conteo=> "+conteo);
    }

     public void processAllDataInParallel(List<Integer> data) {
         long conteo = data.parallelStream().map(a -> processRecord(a)).count();
         System.out.println("conteo=> "+conteo);
     }


}


