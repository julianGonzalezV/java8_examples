package algo_ds.sorter;

import java.util.Arrays;

/**
 * For better performance when dealing with large sized arrays
 * This IMPLEMENTATION is a bit different from the others sorting algorithms
 * because is based on recursive calls
 */
public class MergeSort extends SortAlgorithm {



    @Override
    public int[] sort(int[] unsortedArr) {
        int mid = unsortedArr.length/2;
        return new int[0];
    }


    /**
     *
     * @param inputArr
     * @param result
     * @return
     */
    public int[] breakDown(int[] inputArr, int[][] result) {
        int mid = inputArr.length/2;
        if(inputArr.length == 1) {
            return inputArr;
        }

        return new int[0];
    }


    /**
     * Merge step: Take two <SORTED> arrays and merge them
     * @param arr1
     * @param arr2
     * @return
     */
    private int[] merge(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        return mergeIter(arr1,arr2,0, 0, result);
    }
    private int[] mergeIter(int[] arr1, int[] arr2, int posArr1,int posArr2, int[] result){
        int resultPos = posArr1 + posArr2;
        if(resultPos >= result.length) return result;

        if(posArr1 >= arr1.length ){
            result[resultPos] = arr2[posArr2];
            return mergeIter(arr1,arr2,posArr1,++posArr2, result);
        }else if(posArr2 >= arr2.length){
            result[resultPos] = arr1[posArr1];
            return mergeIter(arr1,arr2,++posArr1,posArr2, result);
        }

        if( arr1[posArr1] < arr2[posArr2]){
            result[resultPos] = arr1[posArr1];
            return mergeIter(arr1,arr2,++posArr1,posArr2, result);
        }else{
            result[resultPos] = arr2[posArr2];
            return mergeIter(arr1,arr2,posArr1,++posArr2, result);
        }
    }



    public static void main(String[] args) {
       /*Arrays.stream(new MergeSort().merge(new int[]{23}, new int[]{5})).forEach(System.out::println);
       Arrays.stream(new MergeSort().merge(new int[]{1,5}, new int[]{23})).forEach(System.out::println);
       Arrays.stream(new MergeSort().merge(new int[]{24}, new int[]{7,8})).forEach(System.out::println);*/


    }


}
