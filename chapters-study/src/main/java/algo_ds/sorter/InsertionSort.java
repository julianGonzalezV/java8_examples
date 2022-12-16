package algo_ds.sorter;

import java.util.Arrays;

public class InsertionSort extends SortAlgorithm{
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
     * @complexity O(n square) Better than <<bubble sort>> and <<selection Sort>>
     * Relatively good for partially sorted lists (in those cases the complexity is reduced to almost linear O(n))
     * @return
     */
    @Override
    public int[] sort(int[] unsortedArr) {
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
     * Book version
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

    public static void main(String[] args) {
        Arrays.stream(new InsertionSort().sort( new int[]{10,2,8,6,7,9,3,4,1,0,5})).forEach(System.out::println);
    }
}
