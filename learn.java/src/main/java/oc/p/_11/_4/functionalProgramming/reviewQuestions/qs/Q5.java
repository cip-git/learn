package oc.p._11._4.functionalProgramming.reviewQuestions.qs;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Q5 {

    void a(){
        final IntStream intStream = LongStream
                .of(6l, 8l, 10l)
                .mapToInt(x -> (int) x);

//        intStream
//                .collect()
    }

     static void c(){
         final Double collect = LongStream
                 .of(6l, 8l, 10l)
                 .mapToInt(x -> (int) x)
                 .boxed()
                 .collect(groupingBy(x -> x, toSet()))
                 .keySet()
                 .stream()
                 .collect(Collectors.averagingInt(x -> x));
     }

}
