package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.performing_order_based_tasks;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Any stream operation that is based on order, including
 * findFirst(),
 * limit(),
 * or skip(),
 * may actually perform more slowly in a parallel environment.
 * This is a result of a parallel processing task being forced to coordinate
 * all of its threads in a synchronized-like fashion.
 *
 *
 * With a parallel stream,
 * the JVM can create any number of threads to process the stream.
 * When you call findAny() on a parallel stream,
 * the JVM selects the first thread to finish the task and retrieves its data.
 *
 */
class R {

    static void m(){
        final Integer integer = List
                .of(1, 2, 3, 4, 5)
                .stream()
                .findAny()
                .get();
        System.out.println(integer);
    }

    static void mParallel(){
        final Integer integer = List
                .of(1, 2, 3, 4, 5)
                .parallelStream()
                .findAny()
                .get();
        System.out.println(integer);
    }

    static void m2(){
        final OptionalInt first = IntStream
                .rangeClosed(1, 10)
                .skip(5)
                .limit(2)
                .findFirst();

        System.out.println(first);
    }

    static void m2Parallel(){
        final OptionalInt first = IntStream
                .rangeClosed(1, 10)
                .parallel()
                .skip(5)
                .limit(2)
                .findFirst();

        System.out.println(first);
    }

    public static void main(String[] args) {
//        m();
//        mParallel();

        m2();
        m2Parallel();
    }
}
