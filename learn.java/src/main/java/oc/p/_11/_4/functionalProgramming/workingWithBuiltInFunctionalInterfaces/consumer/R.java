package oc.p._11._4.functionalProgramming.workingWithBuiltInFunctionalInterfaces.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

class R {

    Consumer<String> c  = System.out::println;
    Consumer<String> c2  = s -> s = s.toUpperCase();

    {
        c.andThen(c2).andThen(c).accept("andThen");
    }

    BiConsumer<List<String>, String> bc = List::add;
    BiConsumer<List<String>, String> bc2 = (l, s) ->{
        System.out.println("s: " +s);
        System.out.println("l: " +l);
    };

    {
        bc.andThen(bc2).andThen(bc).andThen(bc2).accept(new ArrayList<>(), "a");
    }

    public static void main(String[] args) {
        new R();
    }
}
