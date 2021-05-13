package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.combining_results_with_collect.performing_a_parallel_reduction_on_a_collector;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.print.Print;

class ToMap {

    static void m(){
        final ConcurrentMap<Integer, String> map = Stream
                .of(1, 2, 3, 4, 5)
                .collect(Collectors.toConcurrentMap(
                        Function.identity(),
                        String::valueOf));

        Print.print(map);
    }

    static void m2(){
        final ConcurrentMap<Integer, String> map = Stream
                .of(1, 2, 3, 4, 5)
                .collect(Collectors.toConcurrentMap(
                        Function.identity(),
                        String::valueOf,
                        String::concat));

        Print.print(map);
    }

    static void m3(){
        final ConcurrentMap<Integer, String> map = Stream
                .of(1, 2, 3, 4, 5)
                .collect(Collectors.toConcurrentMap(
                        Function.identity(),
                        String::valueOf,
                        String::concat,
                        ConcurrentSkipListMap::new));

        Print.print(map);
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
    }
}
