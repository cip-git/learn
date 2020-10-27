package oc.p._8._7_Concurrency.workingWithParallelStreams.processingParallelReductions.combiningResultsWithReduce.tw._2;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Rmb {

    Stream <Integer> si() {
        return IntStream.rangeClosed(1, 10000)
                .parallel()
                .mapToObj(i -> i);
    }

    void r() {
        final int identity = 0;
        final BinaryOperator <Integer> binaryOperator = Integer::sum;
        final Integer reduce = si().reduce(identity, binaryOperator);
        System.out.println(reduce);
    }

    void r2() {
        final BinaryOperator <Integer> binaryOperator = Integer::sum;
        final Optional <Integer> reduce = si().reduce(binaryOperator);
        reduce.ifPresent(System.out::println);
    }

    void r3() {
        final int identity = 0;
        final BiFunction <Integer, Integer, Integer> biFunction = (n, o) -> Integer.sum(n.intValue(), o.intValue());
        final BinaryOperator <Integer> binaryOperator = Integer::sum;
        si().reduce(identity, biFunction, binaryOperator);
    }

    void c(){
        final Supplier <LinkedList <Object>> supplier = LinkedList::new;
        final BiConsumer <LinkedList <Object>, Integer> biConsumer = (ll, e) -> ll.add(e);
        final BiConsumer <LinkedList <Object>, LinkedList <Object>> biConsumer2 = (l, l2) -> l.addAll(l2);
        final LinkedList <Object> linkedList = si().collect(supplier, biConsumer, biConsumer2);
    }

}
