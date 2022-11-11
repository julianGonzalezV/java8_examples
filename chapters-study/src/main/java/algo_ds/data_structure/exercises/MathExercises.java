package algo_ds.data_structure.exercises;


public class MathExercises {

    private static int fib2(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib2(n - 1) + fib2(n - 2);
        }
    }

    /**
     * NO ES TAIL RECURSIVE
     * @param n
     * @return
     */
    private static int fibo(int n){
        if(n <= 0) return 0;
        else if(n == 1) {

            return 1;
        }
        else{
            return fibo(n-1)+fibo(n-2);
        }
    }


    private static void fiboGenerator(int nElements){
        for (int i=0; i <= nElements; i++){
            System.out.println(fib2(i));
        }

    }



    public static void main (String[] args){
        System.out.println(fibo(7));
        fiboGenerator(7);
    }
}
