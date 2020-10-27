package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.averaging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.resources.files.Location;

/**
 * static <T> Collector<T,?,Double>	averagingDouble(ToDoubleFunction<? super T> mapper)
 * Returns a Collector that produces the arithmetic mean of a double-valued function applied to the input elements.
 *
 *
 * static <T> Collector<T,?,Double>	averagingInt(ToIntFunction<? super T> mapper)
 * Returns a Collector that produces the arithmetic mean of an integer-valued function applied to the input elements.
 *
 *
 * static <T> Collector<T,?,Double>	averagingLong(ToLongFunction<? super T> mapper)
 * Returns a Collector that produces the arithmetic mean of a long-valued function applied to the input elements.
 */
class Averaging {

    static Path p = Path.of(Location.SRC_MAIN_JAVA.asPath(), "iq");

    static void m() throws IOException {
        final Double collect = Files
                .walk(p, Short.MAX_VALUE)
//                .collect(Collectors.averagingInt(p -> 1));
                .collect(Collectors.averagingLong(p->1));
//                .collect(Collectors.averagingDouble(p -> 1));
    }

}
