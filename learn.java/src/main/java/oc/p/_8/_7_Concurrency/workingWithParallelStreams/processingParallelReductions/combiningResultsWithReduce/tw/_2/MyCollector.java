package oc.p._8._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithReduce.tw._2;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyCollector implements Collector <ZonedDateTime, Map <Integer, ZonedDateTime>, Map <Integer, ZonedDateTime>> {

    @Override
    public Supplier <Map <Integer, ZonedDateTime>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer <Map <Integer, ZonedDateTime>, ZonedDateTime> accumulator() {
        return (map, zdt) -> map.putIfAbsent(zdt.getDayOfYear(), zdt);
    }

    @Override
    public BinaryOperator <Map <Integer, ZonedDateTime>> combiner() {
        return (m, m2) -> {
            m2.forEach((k, v) -> m.putIfAbsent(k, v));
            return m;
        };
    }

    @Override
    public Function <Map <Integer, ZonedDateTime>, Map <Integer, ZonedDateTime>> finisher() {
        return Function.identity();
    }

    @Override
    public Set <Characteristics> characteristics() {
        return Stream.of(Characteristics.IDENTITY_FINISH).collect(Collectors.toSet());
    }
}

class Run {
    static void m() {
        final Map <Integer, ZonedDateTime> map = Stream.of(ZonedDateTime.now()).collect(new MyCollector());
        System.out.println(map);
    }

    public static void main(String[] args) {
        m();
    }
}


