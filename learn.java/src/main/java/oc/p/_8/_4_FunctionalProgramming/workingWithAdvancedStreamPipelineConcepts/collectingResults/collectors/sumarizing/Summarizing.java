package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.sumarizing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.summarizingLong;

import utils.javaClass.Elephant;

/**
  *
 * static <T> Collector<T,?,IntSummaryStatistics>	summarizingInt(ToIntFunction<? super T> mapper)
 *          Returns a Collector which applies an int-producing mapping function to each input element, and returns summary statistics for the resulting values.
 *
 *
 * static <T> Collector<T,?,LongSummaryStatistics>	summarizingLong(ToLongFunction<? super T> mapper)
 *          Returns a Collector which applies an long-producing mapping function to each input element, and returns summary statistics for the resulting values.
 *
 *
 * static <T> Collector<T,?,DoubleSummaryStatistics>	summarizingDouble(ToDoubleFunction<? super T> mapper)
 *          Returns a Collector which applies an double-producing mapping function to each input element, and returns summary statistics for the resulting values.
 */
class Summarizing {

    static void m(){
        final IntSummaryStatistics iss = streamOf()
                .collect(Collectors.summarizingInt(Elephant::getWeight));

        final int min = iss.getMin();
        final int max = iss.getMax();
        final long count = iss.getCount();
        final long sum = iss.getSum();
        final double average = iss.getAverage();
    }

    static void m2(){
        final LongSummaryStatistics lss = streamOf()
                .collect(summarizingLong(Elephant::getWeight));

        final long min = lss.getMin();
        final long max = lss.getMax();
        final long count = lss.getCount();
        final long sum = lss.getSum();
        final double average = lss.getAverage();
    }

    static void m3(){
        final DoubleSummaryStatistics dss = streamOf()
                .collect(summarizingDouble(Elephant::getWeight));
        final double min = dss.getMin();
        final double max = dss.getMax();
        final long count = dss.getCount();
        final double sum = dss.getSum();
        final double average = dss.getAverage();
    }

    private static Stream<Elephant> streamOf() {
        return Stream
                .generate(Elephant::newOne)
                .limit(10)
                .peek(System.out::println);
    }

    public static void main(String[] args) {
        m();
    }
}
