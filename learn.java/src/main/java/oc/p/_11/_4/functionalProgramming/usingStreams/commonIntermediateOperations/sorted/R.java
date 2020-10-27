package oc.p._11._4.functionalProgramming.usingStreams.commonIntermediateOperations.sorted;

import java.util.Comparator;
import java.util.stream.Stream;

class R<T extends Comparable<? super T>> {

    Stream<Integer> source;

    {
        final Comparator<T> naturalOrder = Comparator.naturalOrder();

        final Comparator<T> reverseOrder = Comparator.reverseOrder();

        final Comparator<T> reversed = naturalOrder.reversed();
    }

    private void init() {
        source = Stream.iterate(1, i -> i < 10, i -> i + 1);
    }

    void reversed(){
        source
//                .sorted(Comparator::reversed)  //reversed doesn't take 2 arguments
//                .sorted(Comparator.reversed())  //is an instance method
                .sorted();
    }


    void naturalOrder(){
        source
//                .sorted(Comparator::naturalOrder)  //naturalOrder is method which doesn't take 2 arguments
                .sorted(Comparator.naturalOrder())
                .sorted();
    }

    void reverseOrder(){
        source
//                .sorted(Comparator::reverseOrder)  //reverseOrder is a method which doesn't take 2 arguments
                .sorted(Comparator.reverseOrder())
                .sorted();

    }

}