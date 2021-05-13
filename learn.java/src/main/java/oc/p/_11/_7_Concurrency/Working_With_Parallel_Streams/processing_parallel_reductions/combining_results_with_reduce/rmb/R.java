package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.combining_results_with_reduce.rmb;

import java.util.List;
import java.util.Optional;

class R {

    public static void main(String[] args) {
        m();
        m2();
        m3();
    }

    static void m() {
        final Integer reduce = List
                .of(1, 2, 3, 4, 5)
                .stream()
                .reduce(0, (o, n) -> o + n, (o, o2) -> o + o2);

        System.out.println(reduce);
    }

    static void m2() {
        final Integer reduce = List
                .of(1, 2, 3, 4, 5)
                .stream()
                .reduce(0, (o, o2) -> o + o2);

        System.out.println(reduce);
    }

    static void m3() {
        final Optional<Integer> reduce = List
                .of(1, 2, 3, 4, 5)
                .stream()
                .reduce((o, o2) -> o + o2);
        System.out.println(reduce.get());
    }
}
