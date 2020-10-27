package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.partitioningBy;

import static utils.print.Print.print;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.javaClass.PathOf;

/**
 * static <T> Collector<T,?,Map<Boolean,List<T>>>	partitioningBy(Predicate<? super T> predicate)
 * Returns a Collector which partitions the input elements according to a Predicate, and organizes them into a Map<Boolean, List<T>>.
 *
 * static <T,D,A> Collector<T,?,Map<Boolean,D>>	partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream)
 * Returns a Collector which partitions the input elements according to a Predicate,
 * reduces the values in each partition according to another Collector,
 * and organizes them into a Map<Boolean, D> whose values are the result of the downstream reduction.
 */
class PartitioningBy {

    static void m() throws IOException {
        final Map<Boolean, Map<Boolean, Map<Boolean, Long>>> collect = Files
                .find(
                        PathOf.SRC_MAIN_JAVA_GTK.getValue(),
                        Byte.MAX_VALUE,
                        (p, bfa) -> bfa.isRegularFile())
                .collect(
                        Collectors.partitioningBy(
                                p -> p.getFileName().toString().startsWith("A"),
                                Collectors.partitioningBy(
                                        p -> p.getFileName().startsWith("B"),
                                        Collectors.partitioningBy(
                                                p -> p.startsWith("C"),
                                                Collectors.counting()
                                        ))));
        print(collect);
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
