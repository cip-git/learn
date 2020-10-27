package oc.p._11._4.functionalProgramming.usingStreams.commonIntermediateOperations.sorted;

import java.util.Comparator;
import java.util.stream.Stream;

import utils.javaClass.Elephant;
import utils.javaClass.implemets.serializable.simple.TeaPot;

class R2 {

    Stream<TeaPot> source = Stream.empty();

    Comparator<TeaPot> comparator = Comparator.comparing(TeaPot::getLocalDateTime);

    void naturalOrder(){
//        source.sorted(Comparator.naturalOrder();  //CE TeaPot isn't Comparable
    }

    void reverseOrder(){
//        source.sorted(Comparator.reverseOrder());  //CE TeaPot isn't Comparable
    }

    void reversed(){

        final Comparator<TeaPot> reversed = comparator.reversed();

        source.sorted(reversed);
    }
}
