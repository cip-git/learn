package oc.p._8._4_FunctionalProgramming.workingWithPrimitives.tw._2;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class IntStreamClass {

    public static final Comparator<Integer> COMPARATOR = Comparator.comparingInt(Integer::intValue);
    static IntStream is = IntStream
            .iterate(1, i -> i + 1)
            .limit(5);

    static Stream<Integer> si = is.mapToObj(i->i);


    static void m3(){
        final Optional<Integer> min = si.min(COMPARATOR);
        final Optional<Integer> max = si.max(COMPARATOR);

        final long count = si.count();
    }

    static void m2(){
        final OptionalInt min = is.min();
        final OptionalInt max = is.max();

        final long count = is.count();

        final int sum = is.sum();

        final OptionalDouble average = is.average();
    }

    static void m(){
        final IntSummaryStatistics iss = is.summaryStatistics();
        final int min = iss.getMin();
        final int max = iss.getMax();

        final long count = iss.getCount();
        final long sum = iss.getSum();

        final double average = iss.getAverage();
    }

    public static void main(String[] args) {

    }
}
