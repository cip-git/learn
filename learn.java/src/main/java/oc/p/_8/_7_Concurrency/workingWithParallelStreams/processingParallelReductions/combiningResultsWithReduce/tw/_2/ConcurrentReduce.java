package oc.p._8._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithReduce.tw._2;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * combiner(identity, r) -> r
 *
 * acumulator(acumulator(a, b), c) == acumulator(a, acumulator(b, c))
 *
 * combiner(r, t) = combiner(r, acumulator(identity, t))
 */
class ConcurrentReduce {

    public static final BiFunction <String, String, String> ACUMULATOR = String::concat;
    public static final BinaryOperator <String> COMBINER = String::concat;
    public static final String IDENTITY = "";

    public static void main(String[] args) {
        ConcurrentReduce cr = new ConcurrentReduce();

        cr.callM();
        cr.one();
    }

    Stream <String> ss() {
        return Stream.of("w", "o", "l", "f");
    }

    void m(Stream <String> ss) {
        final String res = ss.reduce(IDENTITY, ACUMULATOR, COMBINER);
        System.out.println(res);
    }

    void callM() {
        m(ss());
        m(ss().parallel());
    }

    void one() {
        System.out.println(COMBINER.apply("w", IDENTITY));
    }
}
