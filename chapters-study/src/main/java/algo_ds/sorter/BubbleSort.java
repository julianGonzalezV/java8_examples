package algo_ds.sorter;

import java.util.Arrays;

public class BubbleSort extends SortAlgorithm{

    /**
     * Rules:
     * 1- Only pick one ball at a time.
     * 2- Before picking up another ball, you need to drop the existing ball-in-hand, in an empty basket.
     * 3- You have to start from left most basket and arrange the balls moving towards the RIGHT.
     * 4- You can use a stick to keep track of the sorted part.
     *
     *
     * My Analysis
     * Input array [10,2,8,6]
     * basket : _
     *
     * Iteration 		input Arr cursor		basket
     * 0				[*10,2,8,6]				10
     * 1				[10,*2,8,6]				2   if(2<10)	then swap from [10,2,8,6] to [2,10,8,6]
     * 2				[2,10,*8,6]				8   if(8<10)	then swap from [2,10,8,6] to [2,8,10,6]
     * 3				[2,10,8,*6]				6   if(6<10)	then swap from [2,10,8,6] to [2,8,6,10]
     *
     *
     * Iteration 		input Arr stick		basket
     * 0				[*10,2,1]				10			I if(2<10 and 2<1)	then swap from [10,2,8,6] to [2,10,8,6]
     * 1				[2,*10,8,6]				8   		if(8<10) and 8<6 ) --> No  then
     * Given 8>6 							then swap from [2,10,8,6]to [2,6,8,6]
     * 1				[2,*10,8,6]				6
     *
     *:::::::::::::COMPLEXITY O(n square)-VERY INEFFICIENT:::::::::::
     * @return
     */
   @Override
    public int[] sort(int[] unsortedArr) {
       int basket;
       for(int i = 0 ; i< unsortedArr.length; i++){
           int val = i+1;
           if(val>=unsortedArr.length){
               break;
           }

           if(unsortedArr[i] > unsortedArr[i+1]){
               basket = unsortedArr[i+1];
               unsortedArr[i+1] = unsortedArr[i];
               unsortedArr[i] = basket;
           }

           for(int j = i ; j >0; j -- ){
               if(unsortedArr[j] < unsortedArr[j-1]){
                   basket = unsortedArr[j];
                   unsortedArr[j] = unsortedArr[j-1];
                   unsortedArr[j-1] = basket;
               }
           }

       }
       return unsortedArr;
    }

    public static void main(String... args){
        Arrays.stream(new BubbleSort().sort( new int[]{10,2,8,6,7,9,3,4,1,0,5})).forEach(System.out::println);
    }
}
