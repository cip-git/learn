package oc.p._8._4_FunctionalProgramming.workingWithPrimitives.tw._3;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class PrimitiveStreamClass {

    static DoubleStream ds = DoubleStream
            .iterate(1, i-> i + 1)
            .limit(5);

    static IntStream is = IntStream
            .iterate(1, i -> i + 1)
            .limit(5);

    static LongStream ls = LongStream
            .iterate(1, i-> i + 1)
            .limit(5);


    static void m(){
        final OptionalDouble min = ds.min();
        final OptionalDouble max = ds.max();

        final long count = ds.count();
        final double sum = ds.sum();

        final OptionalDouble average = ds.average();
    }

    static void m2(){
        final OptionalInt min = is.min();
        final OptionalInt max = is.max();

        final long count = is.count();
        final int sum = is.sum();

        final OptionalDouble average = is.average();
    }

    static void m3(){
        final OptionalLong min = ls.min();
        final OptionalLong max = ls.max();

        final long count = ls.count();
        final long sum = ls.sum();

        final OptionalDouble average = ls.average();

    }
}
