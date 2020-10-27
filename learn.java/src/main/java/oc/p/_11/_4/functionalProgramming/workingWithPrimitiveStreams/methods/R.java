package oc.p._11._4.functionalProgramming.workingWithPrimitiveStreams.methods;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class R {

    {
        final IntStream source = IntStream.range(1, 5);
        final Stream<Integer> boxed = source.boxed();

        final long count2 = boxed.count();
        final Optional<Integer> min2 = boxed.min(Comparator.naturalOrder());
        final Optional<Integer> max2 = boxed.max(Comparator.reverseOrder());

        final long count = source.count();
        final int sum = source.sum();

        final OptionalInt min = source.min();
        final OptionalInt max = source.max();
        final OptionalDouble average = source.average();

        final IntSummaryStatistics statistics = source.summaryStatistics();

        final long count1 = statistics.getCount();
        final long sum1 = statistics.getSum();
        final int min1 = statistics.getMin();
        final int max1 = statistics.getMax();
        final double average1 = statistics.getAverage();
    }

    {
        final LongStream source = LongStream.range(1, 10);
        final Stream<Long> boxed = source.boxed();

        final Optional<Long> min2 = boxed.min(Comparator.naturalOrder());
        final Optional<Long> max2 = boxed.max(Comparator.reverseOrder());

        final long count = source.count();
        final long sum = source.sum();

        final OptionalLong min = source.min();
        final OptionalLong max = source.max();
        final OptionalDouble average = source.average();

        final LongSummaryStatistics statistics = source.summaryStatistics();

        final long count1 = statistics.getCount();
        final long sum1 = statistics.getSum();
        final long min1 = statistics.getMin();
        final long max1 = statistics.getMax();
        final double average1 = statistics.getAverage();
    }

    {
        final DoubleStream source = DoubleStream.iterate(1, i -> i < 5, i -> i + 1);
        final Stream<Double> boxed = source.boxed();

        final Optional<Double> min2 = boxed.min(Comparator.comparingDouble(d -> d));
        final Optional<Double> max2 = boxed.max(Comparator.comparingDouble(d -> d));

        final long count = source.count();
        final double sum = source.sum();

        final OptionalDouble min = source.min();
        final OptionalDouble max = source.max();
        final OptionalDouble average = source.average();

        final DoubleSummaryStatistics statistics = source.summaryStatistics();

        final long count1 = statistics.getCount();
        final double sum1 = statistics.getSum();

        final double min1 = statistics.getMin();
        final double max1 = statistics.getMax();
        final double average1 = statistics.getAverage();
    }

    {
        final IntStream range = IntStream.range(1, 5);
        final Stream<Integer> boxed = range.boxed();

        final Integer collect = boxed
                .collect(Collectors.summingInt(i -> i));
    }
}
