package oc.p._11._4.functionalProgramming.workingWithBuiltInFunctionalInterfaces.convenienceMethodsOnFunctionalInterfaces;

import java.util.function.Function;

class F {

    static Function<Integer, Integer> f = i -> {
        System.out.println("f");
        return i + 1;
    };

    static Function<Integer, Integer> f2 = i -> {
        System.out.println("f2");
        return i + 2;
    };

    static Function<Integer, Integer> f3 = i -> {
        System.out.println("f3");
        return i + 3;
    };

    static void m(){
        var i = 0;

        final Integer res = f.andThen(f2).andThen(f3).apply(i);
        System.out.println(res);

        final Function<Integer, Integer> compose = f.compose(f2).compose(f3);
        final Integer res2 = compose.apply(i);
        System.out.println(res2);
    }

    public static void main(String[] args) {
        m();
    }
}
