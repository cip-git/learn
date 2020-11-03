package oc.p._11._4.functionalProgramming.reviewQuestions.qs;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class Q11 {

    static void m(){
        final var var = Stream
//                .iterate(1, x -> x++)
                .iterate(1, x -> ++x)
                .limit(5)
//                .map(x -> "" + x)
                .map(x -> x + "")
                .collect(Collectors.joining());
        System.out.println(var);

    }

    //f, g,

    public static void main(String[] args) {
        m();
    }
}
