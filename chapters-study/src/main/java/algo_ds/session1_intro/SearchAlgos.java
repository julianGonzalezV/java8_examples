package algo_ds.session1_intro;

import com.sun.org.apache.xpath.internal.functions.Function3Args;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Teory: https://docs.google.com/document/d/1IcP1klRmt9smCmJ-Q9FMVX0Ce2prhNYo80Hc1CEYc9I/edit
 *
 */
public class SearchAlgos {

    /**
     * It uses te Divide and Conquer Strategy
     * THIS IS THE WHILE LOOP VERSION
     * @param arr
     * @param n
     * @Complexity O(log base 2 N): This is a really fast algorithm
     * @return element position
     */
    public static int binarySearch(int[] arr, int n){
        int minIndex = 0;
        int maxIndex = arr.length;
        int midPos = (maxIndex+minIndex)/2;
        while (arr[midPos] != n){
            if(n > arr[arr.length-1] || n < arr[0]) return -1;
            if(n > arr[midPos]) {
                minIndex = midPos;
            }
            else {
                maxIndex = midPos;
            }
            midPos = (maxIndex+minIndex)/2;
        }
        return midPos;
    }

    private static int binarySearchIter(int[] arr, int n,int minPos,int maxPos){
        int midPos = (maxPos+minPos)/2;
        if(n > arr[arr.length-1] || n < arr[0]) return -1;
        if(arr[midPos] == n) return midPos;
        if(n > arr[midPos]) return binarySearchIter(arr, n , midPos, maxPos);
        else  return binarySearchIter(arr, n , minPos, midPos);
    }

    public static int binarySearchRecursive(int[] inArr, int number){
        return binarySearchIter(inArr, number , 0, inArr.length);
    }

    public static void main(String ... args){
        //System.out.println(binarySearchRecursive(new int[]{10,11,12}, 1));
        //System.out.println(binarySearchRecursive(new int[]{2,10}, 2));
        System.out.println(binarySearchRecursive(new int[]{3,7,20,32,45,55,60,75}, 60));
        System.out.println(binarySearch(new int[]{3,7,20,32,45,55,60,75}, 60));
        System.out.println(binarySearch(new int[]{10,11,12}, 11));
    }
}
