package algo_ds.session1_intro;


import java.util.Arrays;

public class SortAlgos {

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
    public static int[] bubbleSort( int[]  unsortedArr){
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

    /**
     * Call selection because every time (inner for) we select the smallest number
     * @param unsortedArr
     * :::::::::::::COMPLEXITY O(n square)-Better than bubble sort given it is independent of elements order:::::::::::
     * @return
     */
    public static int[] selectionSortMyVersion(int[] unsortedArr){
        for (int i = 0 ; i<unsortedArr.length; i++){
            int basket = unsortedArr[i];
            int minPos = 0;
            int min = Integer.MAX_VALUE;

            for (int j = i ; j<unsortedArr.length; j++ ){
                if(unsortedArr[j]<min){
                    min = unsortedArr[j];
                    minPos = j;
                }
            }
            unsortedArr[i] = min;
            unsortedArr[minPos] = basket;
        }
        return unsortedArr;
    }


    /**
     * Description: On each iteration it gets the smaller element and swap it to the current pivot
     * Final Version of previous one Line68
     * @param unsortedArr
     * :::::::::::::COMPLEXITY O(n square)-Better than bubble sort given it is independent of elements order:::::::::::
     * @return
     */
    public static int[] selectionSort(int[] unsortedArr){
        for (int i = 0 ; i<unsortedArr.length; i++){
            int basket = unsortedArr[i];
            int minPos = i;//because it is supposed that the current position should be the minimum

            for (int j = i ; j<unsortedArr.length; j++ ){
                if(unsortedArr[j]<unsortedArr[minPos]){
                    minPos = j;
                }
            }
            unsortedArr[i] = unsortedArr[minPos] ;
            unsortedArr[minPos] = basket;
        }
        return unsortedArr;
    }


    /**
     * My Version :) previous to see online versions
     * How does it work?
     * Example input:   [10, 2, 8, 6, 7, 3]
     * Expected Output: [2, 3, 6, 7, 8, 10]
     *
     * Steps:
     * index
     *  0 -       [2, 10, 8, 6, 7, 3] --> 10 in example input is greater than 2 so swap;  2 and 10 are sorted now let's continue with 8
     *  1 -       [2, 8, 10, 6, 7, 3] --> 8 is lower than 10  so swap, 8 is greater than 2 so let's continue with 6
     *  2 -       [2, 8, 6, 10, 7, 3] --> 6 is lower than 10  so swap,
     *  3 -       [2, 6, 8, 10, 7, 3] --> 6 is lower than 8  so swap,6 is greater than 2 so let's continue with 7
     *  4 -       ...
     * @param unsortedArr
     * @complexity O(n square) Better than bubble sort and selection Sort
     * Relatively good for partially sorted lists (the complexity is reduce to almost linear O(n))
     * @return
     */
    public static int[] insertionSort(int[] unsortedArr){
        for(int i = 0; i < unsortedArr.length; i++){
            for(int j = i; j>0; j-- ){
                if((unsortedArr[j] < unsortedArr[j-1])){
                    int bucket = unsortedArr[j];
                    unsortedArr[j] = unsortedArr[j-1];
                    unsortedArr[j-1] = bucket;
                }else {
                    break;
                }

            }
        }
        return unsortedArr;
    }

    /**
     * Online version
     * @param unsortedArr
     * @return
     */
    public static int[] insertionSortV2(int[] unsortedArr){
        for(int i = 0; i < unsortedArr.length; i++){
            int bucket = unsortedArr[i];
            int j = i -1;
            // this comparison unsortedArr[j]>bucket() makes the sort stable (no elements are moved if they are equal)
            while (j >= 0 && unsortedArr[j]>bucket) {
                unsortedArr[j+1] = unsortedArr[j];
                j--;
            }
            unsortedArr[j+1] = bucket;
        }
        return unsortedArr;
    }

    public static void main(String ... args) {
       //Arrays.stream(bubbleSort( new int[]{10,2,8,6,7,3})).forEach(System.out::println);
       // Arrays.stream(insertionSort( new int[]{10,2,8,6,7,9,3,4,1,0,5})).forEach(System.out::println);
        //Arrays.stream(selectionSort( new int[]{10,8,7,6})).forEach(System.out::println);
       // Arrays.stream(selectionSort( new int[]{1,0})).forEach(System.out::println);
        //Arrays.stream(insertionSort( new int[]{0,1,2})).forEach(System.out::println);
        //Arrays.stream(insertionSort( new int[]{1,0,2})).forEach(System.out::println);
       // Arrays.stream(insertionSort( new int[]{1,2,0})).forEach(System.out::println);
        //Arrays.stream(insertionSort( new int[]{2,10})).forEach(System.out::println);
        //Arrays.stream(insertionSort( new int[]{2,10,8})).forEach(System.out::println);
        //Arrays.stream(insertionSort( new int[]{2,10,8,6})).forEach(System.out::println);

        //Arrays.stream(insertionSort( new int[]{2,1,0})).forEach(System.out::println);

        Arrays.stream(insertionSort( new int[]{10,2,8,6,7,9,3,4,1,0,5})).forEach(System.out::println);
        System.out.println("Course Version:");
        Arrays.stream(insertionSortV2( new int[]{10,2,8,6,7,9,3,4,1,0,5})).forEach(System.out::println);
    }
}
