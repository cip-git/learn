package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.counting;

import java.io.IOException;
import java.nio.file.Files;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import utils.javaClass.PathOf;

/**
 * static <T> Collector<T,?,Long>	counting()
 * Returns a Collector accepting elements of type T that counts the number of input elements.
 *
 *
 * The IntStream, DoubleStream and LongStream collect method doesn't have an overloaded version which accept a Collectors parameter
 */
class Counting {

    static void m() throws IOException {
        final Long collect = Files
                .walk(PathOf.SRC_MAIN_JAVA.getValue())
                .collect(Collectors.counting());
        System.out.println(collect);
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
