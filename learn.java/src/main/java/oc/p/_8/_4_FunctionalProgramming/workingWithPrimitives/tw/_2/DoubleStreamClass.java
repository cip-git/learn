package oc.p._8._4_FunctionalProgramming.workingWithPrimitives.tw._2;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class DoubleStreamClass {

    public static final Comparator<Double> COMPARATOR = Comparator.comparingDouble(d -> d);
    DoubleStream ds = DoubleStream
            .iterate(1, d -> d + 1)
            .limit(5);

    Stream<Double> sd = ds.mapToObj(d -> d);

    void m3(){
        final Optional<Double> min = sd.min(COMPARATOR);
        final Optional<Double> max = sd.max(COMPARATOR);

        final long count = sd.count();
    }

    void m2(){
        final OptionalDouble min = ds.min();
        final OptionalDouble max = ds.max();

        final long count = ds.count();

        final double sum = ds.sum();
        final OptionalDouble average = ds.average();
    }

    void m(){
        final DoubleSummaryStatistics dss = ds.summaryStatistics();

        final double min = dss.getMin();
        final double max = dss.getMax();

        final long count = dss.getCount();

        final double sum = dss.getSum();
        final double average = dss.getAverage();
    }
}
