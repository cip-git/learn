package oc.p._11._4.functionalProgramming.workingWithPrimitiveStreams.methods.flatMap;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class R {

    static void m(){
        var intergerList = new ArrayList<Integer>();

        final Stream<Integer> stream = intergerList.stream();

        final IntStream intStream = stream.flatMapToInt(x -> IntStream.of(x));
        stream.mapToInt(x -> x);

        final Stream<Integer> integerStream = stream.flatMap(x -> Stream.of(x));
    }
}
