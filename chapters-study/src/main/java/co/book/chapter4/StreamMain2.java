package co.book.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamMain2 {

    static String findNumber(int[] arr, int k) {
        return Arrays.stream(arr).filter(x-> x == k).count() > 0 ? "Y":"N";
    }

    private static boolean isPrime(int n){
        return IntStream.range(2, n).filter(x-> n%x == 0).count()<1;
    }

    private static int[]  oddNumbers(int i, int j){
       return IntStream.rangeClosed(i,j).filter(x-> x%2 !=0).toArray();
    }



    private static int[] primeFiboNumbers(int n){
        //importante hacer el reset por ser una variable static, al existir concurrencia puodria fallar el
        //computo, mientras que asi cada computo inicia por reset de la variable
        FibonacciGenerator.resetSeries();
       int currentFibVal = FibonacciGenerator.getNext();
       int currentPrimeVal = PrimeGenerator.getNext();

       List<Integer> fiboList = new ArrayList<>();
       List<Integer> primeList = new ArrayList<>();

       //verificar si es verdad que el limite lo pone el prime Operation, yo lo veo como que es el
        //prime el que aumenta mas rapido entonces si lo limoto al fibo pueda que se pierdan valores
       while (currentFibVal<= n ){
           fiboList.add(currentFibVal);
           currentFibVal = FibonacciGenerator.getNext();
       }

        while (currentPrimeVal<= n  ){
            primeList.add(currentPrimeVal);
            currentPrimeVal = PrimeGenerator.getNext();
        }


        //testing the output, delete when deliver

        System.out.println(":::::::::::::::::::::::::::::");
        System.out.print("fiboList  "+fiboList);
        System.out.println();
        System.out.print("primeList  "+primeList);
        System.out.println();
        System.out.println(":::::::::::::::::::::::::::::");

       List<Integer> resultList = new ArrayList<>();

        for (Integer i : primeList) {
            if(fiboList.contains(i)){
                resultList.add(i);
            }
        }

        int[] result  = new int[resultList.size()];
        for (int i =0 ; i<resultList.size(); i++) {
            result[i] = resultList.get(i);
        }


        //testing the output, delete when deliver
        for (Integer i:result
                ) {
            System.out.println("result  "+i);

        }
        return result;
    }


    public static void main(String[] args) {
        /*
        int[] arr ={1, 2, 5, 4, 6, 7, 8, 9};
        System.out.println(findNumber(arr, 7));

        System.out.println(isPrime(2));

        Arrays.stream(oddNumbers(2,5)).forEach(System.out::println);
        */

        int[] primFib = primeFiboNumbers(200);

    }




}
