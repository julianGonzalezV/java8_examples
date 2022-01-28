package co.book.exercises.bynary;

public class BinaryOperations {

    /**
     *
     *
     * The method must return the count of repeated operations required to be
     * done to achieve minimal natural value.
     * Rounding is ineligible.
     * @param args
     *
     * Example
     * 1011
     *
     *Performance in java
     *
     */

    /**
     * 20 --> 10 --> 5 R 2
     * @param input
     * @return
     */
    public static int validateNumber(String input){
        //return calcutateOperationsLoop(transformToInteger(input));
        return calcutateOperationsRecursive(transformToInteger(input), 0);
    }

    public static int calcutateOperationsRecursive(int number, int counter){
        if(isEven(number))
            return calcutateOperationsRecursive((number/2), counter+1);
        else
            return counter;
    }

    public static int calcutateOperationsLoop(int number){
        int counter = 0;
        while(isEven(number)){
            number = number/2;
            counter++;
        }
        return counter;
    }

    public static int transformToInteger(String number){
        System.out.println("transformToInteger is "+ Integer.parseInt(number, 2));
        return Integer.parseInt(number, 2);
    }

    public static boolean isEven(int number){
        return number % 2 == 0;
    }

    /**
     * bit shifting >> or <<
     * @param args
     */


    public static void main(String ... args){
        System.out.println("-----Byna---");
        System.out.println(validateNumber("100001000000"));
        System.out.println(validateNumber("10011000000000"));
        System.out.println(validateNumber("10100"));

    }
}
