package com.examples;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainMySortExample {
    public static void main(String... args){
       SortingTest1 test1 = new SortingTest1(Arrays.asList(4, 3, 2, 1));
        /*test1.sortElems();*/

        LinkedList<Integer> l1 = new LinkedList();
        l1.add(5);
        l1.add(4);
        l1.add(3);
        l1.add(2);
        l1.add(2);
        //System.out.println(l1);


        List<Double> l2 = new ArrayList();
        l2.add(0.78);
        l2.add(0.17);
        l2.add(0.39);
        l2.add(0.26);
        l2.add(0.72);
        l2.add(0.94);
        l2.add(0.21);
        l2.add(0.12);
        l2.add(0.23);
        l2.add(0.68);
        //System.out.println(l2);

        //test1.bucketSort(l2);

        test1.bucketSort(l2);


    }


}
