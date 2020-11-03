package oc.p._11._4.functionalProgramming.reviewQuestions.qs;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.print.Print;

class Q16 {

    Predicate<String> empty = String::isEmpty;
    Predicate<String> notEmpty = empty.negate();

    void m(){
        final Map<String, List<String>> collect = Stream
                .generate(() -> "")
                .limit(10)
                .filter(notEmpty)
                .collect(Collectors.groupingBy(k -> k));

        Print.print(collect.size());

        final Map<Boolean, List<String>> collect1 = collect
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.partitioningBy(notEmpty));

        Print.print(collect1);
    }

    public static void main(String[] args) {
        final Q16 run = new Q16();
        run.m();
    }
}


