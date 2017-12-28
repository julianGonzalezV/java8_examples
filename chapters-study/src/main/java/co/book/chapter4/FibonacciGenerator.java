package co.book.chapter4;

public class FibonacciGenerator {

    private static int currentStep = 0;

    private FibonacciGenerator() {
    }

    private static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * Resets the Fibonacci series.
     */
    public static void resetSeries() {
        currentStep = 0;
    }

    /**
     * Returns the last number in the current Fibonacci series.
     */
    public static int getNext() {
        return fib(++currentStep);
    }
}
