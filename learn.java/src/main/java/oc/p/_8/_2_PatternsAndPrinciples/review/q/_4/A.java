package oc.p._8._2_PatternsAndPrinciples.review.q._4;

import utils.javaClass.hierrarchy.methods.alphabet.E;

import java.util.function.*;

class A {
    Supplier <String> supplier = () -> "";

    BinaryOperator <Integer> binaryOperator = (x, y) -> x + y;
    BiFunction <Integer, Long, Long> biFunction = (x, y) -> y;
    Function <E, Integer> function = (E e) -> {
        return 0;
    };
    Consumer <E> consumer = (E e) -> {
        return;
    };

    I i = () -> {
    };

    {
//        binaryOperator = x, y -> x;
        binaryOperator = (Integer x, Integer y) -> x + y;
    }

    interface I {
        void m();
    }
}
