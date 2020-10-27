package oc.p._8._4_FunctionalProgramming.workingWithPrimitives.tw._2;

import java.util.Comparator;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class LongStreamClass {

    public static final Comparator<Long> COMPARATOR = Comparator.comparingLong(l -> l);
    LongStream ls = LongStream
            .iterate(1, i-> i+1)
            .limit(5);

    Stream<Long> sl = ls.mapToObj( i-> i);

    void m3(){
        final Optional<Long> min = sl.min(COMPARATOR);
        final Optional<Long> max = sl.max(COMPARATOR);

        final long count = sl.count();
    }

    void m2(){
        final OptionalLong min = ls.min();
        final OptionalLong max = ls.max();

        final long count = ls.count();

        final long sum = ls.sum();
        final OptionalDouble average = ls.average();
    }

    void m(){
        final LongSummaryStatistics lss = ls.summaryStatistics();

        final long min = lss.getMin();
        final long max = lss.getMax();
        final long count = lss.getCount();

        final long sum = lss.getSum();
        final double average = lss.getAverage();
    }
}
