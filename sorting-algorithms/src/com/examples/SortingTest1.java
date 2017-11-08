package com.examples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingTest1 {

    private List elemsToSort;

    public SortingTest1(List elemsToSort) {
        this.elemsToSort = elemsToSort;
    }


    public List sortElems() {
        if (elemsToSort.isEmpty())
            return new ArrayList();

        List sortedL = new ArrayList();
        System.out.println("los elementos a ordenar son" + elemsToSort);

        for (Object ele : elemsToSort) {

            if (sortedL.isEmpty()) {
                sortedL.add(ele);
            } else {
                int firstEl = (Integer) sortedL.get(0);

            }
        }
        System.out.println("Elementos ordenados" + sortedL);
        return sortedL;
    }


    /**
     *
     * @param unsortedElems
     * @return
     */
    public List bucketSort(List<Double> unsortedElems) {
        if (unsortedElems.isEmpty()) return new ArrayList();
        int n = unsortedElems.size();
        List<List<Double>> buckets =  getBuckets(n);
        for (Double elem : unsortedElems) {
            System.out.println(elem);
            Double bi = Math.floor(n * elem);
            buckets.get(bi.intValue()).add(elem);
        }

        Stream<List<Double>> stream = buckets.stream();
        Stream<List<Double>> stream2 = stream.map(x -> insertionSort(x));
        //stream2.reduce(List<Double>(), )

        System.out.println(buckets);
        return null;
    }


    /**
     *
     * @param sizeE
     * @return
     */
    private List<List<Double>>  getBuckets(int sizeE){
        List<List<Double>> buckets =  new ArrayList<>();
        for(int i = 0; i< sizeE; i++){
            buckets.add(new ArrayList<>());
        }
        return buckets;
    }


    /**
     * OJO SI LO QUE SE desea es un método que reciba cualqier tipo de dato entonces podríamos
     * hacer una interface y sus implementaciones para cada tipo Double, Integer, etc
     * @param unsortedElems
     * @return
     */
    public List insertionSort1(List <Double> unsortedElems){
        if (unsortedElems.isEmpty()) return new ArrayList();
        List <Double> sortedElems = new ArrayList<>();
        int n = unsortedElems.size();

        for(int i=0; i< n ; i++){
            Double pi = unsortedElems.get(i);
            if(i==0){
                sortedElems.add(i, pi);
                continue;
            }
            for(int j = 0; j< i; j++ ){
                Double pj1 = sortedElems.get(j);

                if(j== (sortedElems.size()))
                    sortedElems.add(j, pi);
                else if(pj1 > pi) {
                    sortedElems.set(j, pi);
                    sortedElems.add(j+1, pj1);
                    pi = sortedElems.get(j+1);
                }
            }

        }
        System.out.println(sortedElems);

        return  sortedElems;

    }


    /**
     * insertionSort method
     * @param unsortedElems
     * @return sorted elements
     */
    public List insertionSort(List <Double> unsortedElems){
        if (unsortedElems.isEmpty()) return new ArrayList();
        List <Double> sortedElems = unsortedElems;

        for(int i=1; i< sortedElems.size() ; i++){
            Double pi = sortedElems.get(i);
            int j = i;
            while (j>0 && sortedElems.get(j-1)>pi){
                sortedElems.set(j, sortedElems.get(j-1));
                j--;
            }
            sortedElems.set(j,pi);
        }

        System.out.println(sortedElems);
        return sortedElems;
    }


    private List getEmptyList(int n){
        List emptyL = new ArrayList();
        for(int i=0;i<n; i++){
            emptyL.add(-777.0);
        }
        return emptyL;
    }

}

