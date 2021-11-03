package com.examples;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * La clase trabaja con ambos Array y List
 */
public class MergeSort {

    public static int[] subArray(int[] arr , int from, int to){
        int size = to-from;
        int[] result = new int[size+1];
        for(int i = from, index = 0  ; i<=to; i++, index++){
            result[index] = arr[i];
        }
        return result;
    }

    public static int[] sort(int[] input){
        if(input.length == 1){
            return input; // Is already ordered
        }
        int m = (input.length/2) -1 ;
        int[] a1 = subArray(input, 0, m);
        int[] a2 = subArray(input, m+1, input.length-1);
        int[] sortedArray = merge(sort(a1), sort(a2));
        return sortedArray;
    }

    /**
     * Both collections (a an b) Must be ordered
     * @param a
     * @param b
     * @return a merged ordered list
     * Example
     * Input
     * [27, 38, 49] [25, 36, 42]
     * Output:
     * [25, 27, 36, 38, 42]
     */
    public static List<Integer> merge(List<Integer> a, List<Integer> b){
        int aIndex = 0;
        int bIndex = 0;
        int asize =  a.size();
        int bsize = b.size();
        int fullsize = asize+bsize;
        List<Integer> result = new ArrayList<>();
        while (result.size() < fullsize-1){
            if(a.get(aIndex) > b.get(bIndex)){
                result.add(aIndex+bIndex, b.get(bIndex));
                if(bIndex < bsize) bIndex++;
            }else{
                result.add(aIndex+bIndex, a.get(aIndex));
                if(aIndex < asize) aIndex++;
            }
        }

        return result;
    }

    /**
     * Old java Array version
     * @param a
     * @param b
     * @return a merged ordered list
     * Example
     * Input
     * [27, 38, 49] [25, 36, 42]
     * Output:
     * [25, 27, 36, 38, 42]
     */
    public static int[] merge(int[] a, int[] b){
        int aIndex = 0;
        int bIndex = 0;
        int counter = 0;
        int aSize =  a.length;
        int bSize = b.length;
        int fullSize = aSize+bSize;
        int[] result =new int[fullSize];
        while (counter<= fullSize-1){
            int aValue = (aIndex < aSize)? a[aIndex] : 99999 ;
            int bValue = (bIndex < bSize)? b[bIndex] : 99999 ;

                if(aValue > bValue){
                    result[aIndex+bIndex] =  bValue;
                    bIndex++;
                }

                if(aValue < bValue){
                    result[aIndex+bIndex] =  aValue;
                    aIndex++;
                }

            counter++;
        }
        return result;
    }

    public static void main(String ... args){
        //int[] a1 = new int[]{27, 38, 49};
        /*System.out.println(merge(List.of(27, 38, 49), List.of(25, 36, 42)));
        int[] a2 = merge(new int[]{27, 38, 49}, new int[]{25, 36, 42});
        for (int i = 0 ; i<a2.length; i++){
            System.out.println(a2[i]);
        }


        int[] a3 = merge(new int[]{49}, new int[]{25});
        for (int i = 0 ; i<a3.length; i++) {
            System.out.println(a3[i]);
        }*/

      /*  System.out.println(":::::::subArray::::::::::");
        int[] subA = subArray(new int[]{27, 22, 39}, 0,1);
        for (int i = 0 ; i<subA.length; i++){
            System.out.println(subA[i]);
        }

        System.out.println(":::::::Method Reference::::::::::");
        Arrays.stream(subA).forEach(System.out::println);
*/
        System.out.println(":::::::Merge Sort::::::::::");
        Arrays.stream(sort(new int[]{27, 22, 39, 1, 2, 3 , 100, 200, 84, 34})).forEach(System.out::println);

    }
}
