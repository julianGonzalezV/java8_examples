package co.book.java8.chapter4;

import java.util.LinkedList;
import java.util.List;

public class PrimeGenerator {
    private static List<Integer> currentPrimes = new LinkedList<Integer>();



    private PrimeGenerator() {
    }

    /**
     * Returns the next prime number.
     */
    public static int getNext() {
        if (currentPrimes.size() == 0) {
            currentPrimes.add(2);
            return 2;
        }
        int candidate = currentPrimes.get(currentPrimes.size() - 1);

        while (true) {
            if(isPrime(++candidate)) {
                currentPrimes.add(candidate);
                return candidate;
            }
        }
    }
    private static boolean isPrime(int num) {
        if (num % 2 == 0) return false;
        for (int i = 3; i * i < num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}
