package oc.p._8._4_FunctionalProgramming.workingWithPrimitives.creatingPrimitiveStreams.map;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


class MapStream {

    static Stream<String> stream;
    static IntStream intStream;
    static LongStream longStream;
    static DoubleStream doubleStream;

    static void init() {
        stream = Stream.of("John", "Doe");
        intStream = IntStream.of(1, 2, 3);
        longStream = LongStream.of(1, 2, 3);
        doubleStream = DoubleStream.of(1, 2, 3);
    }

    static void m() {
        init();
        stream.mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return value.length();
            }
        });
    }

    static void m2() {
        init();
        stream.mapToLong(new ToLongFunction<String>() {
            @Override
            public long applyAsLong(String value) {
                return value.length();
            }
        });
    }

    static void m3() {
        init();
        stream.mapToDouble(new ToDoubleFunction<String>() {
            @Override
            public double applyAsDouble(String value) {
                return value.length();
            }
        });
    }

    static void m4() {
        init();
        stream.map(new Function<String, LocalDate>() {
            @Override
            public LocalDate apply(String s) {
                return LocalDate.now();
            }
        });
//        stream.map(s->s);  //Function<String, String>
    }


}
