package oc.p._11._4.functionalProgramming.reviewQuestions.qs;

import java.util.stream.Stream;

class Q1 {

    static void m(){

        var stream = Stream.iterate("", (s) ->  s + "1");

        stream
                .limit(2)
                .map(x -> x + "2")
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        m();
    }
}
