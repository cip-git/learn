package oc.p._11._4.functionalProgramming.workingWithBuiltInFunctionalInterfaces.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

class R {

    Function<String, String> f = s -> s + " f";
    Function<String, String> f2 = s -> s + " f2";
    Function<String, String> f3 = s -> s + " f3";

    {
        final String a = f.andThen(f2).andThen(f3).apply("a");
        System.out.println(a);
    }


    BiFunction<List<String>, String, List<String>> bf = (l, s) ->{
        l.add(s);
        System.out.println("l");
        return l;
    };

    Function<List<String>, Integer> ff = List::size;

    {
        final Integer a = bf.andThen(ff).apply(new ArrayList<>(), "a");
        System.out.println(a);
    }

    public static void main(String[] args) {
        new R();
    }
}
