package oc.p._11._7_Concurrency.Working_With_Parallel_Streams.processing_parallel_reductions.avoiding_stateful_operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import utils.print.Print;

class Issue {

    List<Integer> addValues(IntStream source){
        var data = Collections.synchronizedList(new ArrayList<Integer>());

        source
                .filter(i -> i%2 == 0)
                .forEach(data::add);

        return data;
    }

    void issue(){
        final var l = addValues(IntStream.range(1, 11));
        Print.print(l);

        final var l2 = addValues(IntStream.range(1, 11).parallel());
        Print.print(l2);
    }

    public static void main(String[] args) {
        final var r = new Issue();
        r.issue();
    }
}
