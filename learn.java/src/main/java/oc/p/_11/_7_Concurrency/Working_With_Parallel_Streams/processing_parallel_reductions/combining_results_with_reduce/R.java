package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.combining_results_with_reduce;

import java.io.InputStream;
import java.util.List;
import java.util.stream.IntStream;

import oc.p._11._2.Annotations.GoodPractice;
import oc.p._11._2.Annotations.Rule;

/**
 * <U> U reduce(
 *              U identity,
 *              BiFunction<U,? super T,U> accumulator,
 *              BinaryOperator<U> combiner)
 *
 */
@Rule("Enure that the " +
        "ACCUMULATOR AND COMBINER WORK REGARDLESS OF THE ORDER THEY ARE CALLED IN. " +
        "For example, if we add numbers, we can do so in any order.")

@GoodPractice("Although the one-and two-argument versions of reduce() " +
        "do support parallel processing, " +
        "it is recommended that you use the three-argument version of reduce() " +
        "when working with parallel streams. " +
        "Providing an explicit combiner method allows the JVM to partition the operations " +
        "in the stream more efficiently.")
class R {

    static void m(){
        final String reduce = List
                .of('w', 'o', 'l', 'f')
                .parallelStream()
                .reduce(
                        "",
                        (s, c) -> s + c,
                        (s, s2) -> s + s2);

        System.out.println(reduce);
    }

    static void problematicReduce(){
        final Integer reduce = List
                .of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .reduce(0, (a, b) -> (a - b));
        System.out.println(reduce);
    }

    static void problematicReduce2(){
        final String reduce = List
                .of("w", "o", "l", "f")
                .parallelStream()
                .reduce("X", String::concat);

        System.out.println(reduce);
    }

    public static void main(String[] args) {
//        m();

//        m2();

        problematicReduce2();
    }

    private static void m2() {
        IntStream
                .rangeClosed(1, 1000)
                .parallel()
                .forEach( i-> problematicReduce());
    }

}
