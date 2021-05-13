package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.combining_results_with_collect;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

/**
 * <R> R collect(
 *                  Supplier<R> supplier,
 *                  BiConsumer<R, ? super T> accumulator,
 *                  BiConsumer<R, R> combiner)
 *
 */
class R {

    static void m(){
        final Set<String> collect = Stream
                .of("w", "o", "l", "f")
                .parallel()
                .collect(
                        ConcurrentSkipListSet::new,
                        Set::add,
                        Set::addAll);

        System.out.println(collect);
    }

    public static void main(String[] args) {
        m();
    }
}
