package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.combining_results_with_collect.rmb;

import java.util.ArrayList;
import java.util.List;

class R {

    static void m(){
        final List<Integer> collect = List
                .of(1, 2, 3, 4, 5)
                .stream()
                .collect(
                        ArrayList::new,
                        (l, e) -> l.add(e),
                        (l, l2) -> l.addAll(l2));

        System.out.println(collect);
    }

    public static void main(String[] args) {
        m();
    }
}
