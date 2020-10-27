package oc.p._11._4.functionalProgramming.usingStreams.terminalOperations.match;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

class R {

    List<String> le = Collections.emptyList();
    List<String> lf = List.of("monkey", "2", "chimp");
    Stream<String> si = Stream.generate(() -> "infinite");

    Predicate<String> predicate = s -> s.length() == 5;

    void m(){
        final boolean b = le.stream().anyMatch(predicate);
        final boolean b2 = lf.stream().anyMatch(predicate);
//        final boolean b3 = si.anyMatch(predicate);

        System.out.println(b);
        System.out.println(b2);
//        System.out.println(b3);
    }

    void m2(){
        final boolean b = le.stream().noneMatch(predicate);  //true
        final boolean b2 = lf.stream().noneMatch(predicate);  //false
//        final boolean b3 = si.noneMatch(predicate);  //infinite

        System.out.println(b);
        System.out.println(b2);
//        System.out.println(b3);
    }

    void m3(){
        final boolean b = le.stream().allMatch(predicate);  //false
        final boolean b2 = lf.stream().allMatch(predicate);  //false
        final boolean b3 = si.allMatch(predicate);  //false

        System.out.println(b);
        System.out.println(b2);
        System.out.println(b3);
    }


    public static void main(String[] args) {
        final R r = new R();

//        r.m();
//        r.m2();
        r.m3();
    }

}
