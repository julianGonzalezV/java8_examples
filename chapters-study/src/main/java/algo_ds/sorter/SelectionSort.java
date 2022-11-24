package algo_ds.sorter;

import java.util.Arrays;

public class SelectionSort extends SortAlgorithm {
    /**
     * Call selection because every time (inner for) we select the smallest number
     * @param unsortedArr
     * :::::::::::::COMPLEXITY O(n square)-Better than bubble sort given it is independent of elements order:::::::::::
     * @return
     */
    @Override
    public int[] sort(int[] unsortedArr) {
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
     * Book version
     * @param unsortedArr
     * @return
     */
    public int[] selectionSort(int[] unsortedArr){
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

    public static void main(String[] args) {
        Arrays.stream(new SelectionSort().sort( new int[]{10,2,8,6,7,9,3,4,1,0,5})).forEach(System.out::println);
    }
}
