package oc.p._11._4.functionalProgramming.reviewQuestions.qs;

import java.util.function.Predicate;
import java.util.stream.Stream;

class Q3 {

    static void a(){
        Predicate<String> p = s -> s.length() > 3;

        var stream = Stream.iterate("-", s -> !s.isEmpty(), (s) ->  s + s);

//        var b = stream.noneMatch(p);  //false
//        System.out.println(b);

        var b2 = stream.anyMatch(p);  //true
        System.out.println(b2);

    }


    public static void main(String[] args) {
        a();
    }
}
