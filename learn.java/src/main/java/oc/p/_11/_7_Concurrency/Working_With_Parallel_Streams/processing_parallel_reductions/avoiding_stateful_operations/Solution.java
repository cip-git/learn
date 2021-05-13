package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.avoiding_stateful_operations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.print.Print;

class Solution {

    List<Integer> addValues(IntStream source){
        return source
                .filter(i -> i%2==0)
                .boxed()
                .collect(Collectors.toList());
    }

    void m(){
        Print.print(addValues(IntStream.range(1, 11)));

        Print.print(addValues(IntStream.range(1, 11).parallel()));
    }

    public static void main(String[] args) {
        final var r = new Solution();
        r.m();
    }
}
