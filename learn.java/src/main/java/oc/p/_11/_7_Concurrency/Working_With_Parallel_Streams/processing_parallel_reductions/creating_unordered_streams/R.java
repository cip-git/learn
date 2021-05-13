package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.creating_unordered_streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

class R {

    static void m(){
        final OptionalInt first = IntStream
                .rangeClosed(1, 10)
                .unordered()
                .skip(5)
                .limit(2)
                .findFirst();

        System.out.println(first);
    }

    static void mParallel(){
        final OptionalInt first = IntStream
                .rangeClosed(1, 10)
                .unordered()
                .parallel()
                .skip(5)
                .limit(2)
                .findFirst();

        System.out.println(first);
    }

    public static void main(String[] args) {
        m();
        mParallel();
    }
}
