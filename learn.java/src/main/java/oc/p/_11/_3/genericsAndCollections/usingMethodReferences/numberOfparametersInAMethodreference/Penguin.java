package oc.p._11._3.genericsAndCollections.usingMethodReferences.numberOfparametersInAMethodreference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class Penguin {

    static Integer count(Penguin... cuties){
        return cuties.length;
    }

    Supplier<Integer> l =  () -> Penguin.count();
    Supplier<Integer> m = Penguin::count;

    Function<Penguin, Integer> l2 = p -> Penguin.count(p);
    Function<Penguin, Integer> m2 = Penguin::count;

    BiFunction<Penguin, Penguin, Integer> l3 = (p, p2) -> Penguin.count(p, p2);
    BiFunction<Penguin, Penguin, Integer> m3 = Penguin::count;
}

