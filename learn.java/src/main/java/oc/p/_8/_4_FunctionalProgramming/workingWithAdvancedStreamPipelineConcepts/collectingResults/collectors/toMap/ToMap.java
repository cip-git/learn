package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.toMap;
import static utils.print.Print.print;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.javaClass.PathOf;

/**
 *
 * static <T,K,U> Collector<T,?,Map<K,U>>
 *     toMap(Function<? super T,? extends K> keyMapper,
 *     Function<? super T,? extends U> valueMapper)
 *
 * Returns a Collector that accumulates elements into a Map whose keys and values are the result of
 * applying the provided mapping functions to the input elements.
 *
 *
 * static <T,K,U> Collector<T,?,Map<K,U>>
 *     toMap(Function<? super T,? extends K> keyMapper,
 *     Function<? super T,? extends U> valueMapper,
 *     BinaryOperator<U> mergeFunction
 *
 * Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the
 * provided mapping functions to the input elements.
 *
 *
 * static <T,K,U,M extends Map<K,U>> Collector<T,?,M>
 *     toMap(Function<? super T,? extends K> keyMapper,
 *     Function<? super T,? extends U> valueMapper,
 *     BinaryOperator<U> mergeFunction,
 *     Supplier<M> mapSupplier)
 *
 * Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying
 * the provided mapping functions to the input elements.
 */
class ToMap {

    static Stream<Path> stream = null;

    static {
        try {
            stream = Files
                     .find(
                             PathOf.SRC_MAIN_JAVA.getValue(),
                             Byte.MAX_VALUE,
                             (p, bfa) -> p.getFileName().toString().endsWith(".java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m(){
        final Map<String, Integer> collect = stream
                .collect(Collectors
                        .toMap(
                                p -> p.getFileName().toString(),
                                p -> 1,
                                (v, v2) -> v + v2,
                                TreeMap::new
                        ));
        print(collect);
    }

    public static void main(String[] args) {
        m();
    }

}
