package oc.p._11._4.functionalProgramming.usingStreams.terminalOperations.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class R {

    static void m(){
        final ArrayList<Object> collect = Stream
                .iterate(1, i -> i < 5, i -> i++)
                .collect(
                        ArrayList::new,
                        List::add,
                        List::addAll);
    }
}
