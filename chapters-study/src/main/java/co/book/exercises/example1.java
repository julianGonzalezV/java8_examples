package co.book.exercises;

import java.util.*;

public class example1 {
    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(10, 2, 10, 7, 5, 2, 9, 7, 8, 11,11);
        Set<Integer> set = new HashSet<>();
        int counter = 0;
        for (Integer i: inputList ) {
            if(!set.add(i)) counter++;
        }
        System.out.println(inputList);
        System.out.println("Result => "+ counter );

        //2)
        List<String> strList = Arrays.asList("a,b,c,a,d,e,b,f,g".split(","));
        System.out.println(strList);
        Map<String, Integer> map = new TreeMap<>();
        for (String i: strList ) {
            if(map.put(i, 1)!=null) map.replace(i, map.get(i)+1);
        }
        System.out.println(map);
    }
}
