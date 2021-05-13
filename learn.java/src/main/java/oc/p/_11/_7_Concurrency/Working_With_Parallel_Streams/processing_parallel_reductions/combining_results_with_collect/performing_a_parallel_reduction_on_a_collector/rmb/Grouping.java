package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.combining_results_with_collect.performing_a_parallel_reduction_on_a_collector.rmb;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.print.Print;

class Grouping {

    static void m(){
        final Map<Integer, List<Integer>> map = Stream
                .of(1, 2, 3, 4, 5)
                .collect(Collectors.groupingBy(Function.identity()));

        Print.print(map);
    }

    static void m2(){
        final Map<Integer, Long> map = Stream
                .of(1, 2, 3, 4, 5)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        Print.print(map);
    }

    static void m3(){
        final TreeMap<Integer, List<Integer>> map = Stream
                .of(1, 2, 3, 4, 5)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.toList()));

        Print.print(map);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
