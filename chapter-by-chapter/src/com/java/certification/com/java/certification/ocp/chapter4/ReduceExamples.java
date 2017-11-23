package com.java.certification.com.java.certification.ocp.chapter4;

//import com.java.certification.data.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by juligove on 2017/11/22.
 */
public class ReduceExamples {

    public static void  main(String... args){
        /*
        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));

        //cuando se usa el parallel para la ejecución solamente se
        persons.parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s [%s]\n",
                                    sum, p, Thread.currentThread().getName());
                            return sum += p.getAge();
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s [%s]\n",
                                    sum1, sum2, Thread.currentThread().getName());
                            return sum1 + sum2;
                        });
        */
    }
}
