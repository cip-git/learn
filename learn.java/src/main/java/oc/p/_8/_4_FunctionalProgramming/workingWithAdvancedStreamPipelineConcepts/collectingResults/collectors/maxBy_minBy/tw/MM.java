package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.maxBy_minBy.tw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import utils.javaClass.PathOf;

class MM {

    static void m() throws IOException {
        var var = Files
                .find(
                        PathOf.SRC_MAIN_JAVA_GTK.getValue(),
                        Short.MAX_VALUE,
                        (p, bfa) -> bfa.isRegularFile())
                .map(Path::toString);

        final Optional<String> min = var
                .min(Comparator.comparingInt(String::length));
        min.ifPresent(System.out::println);

//        final Optional<String> collect = var
//                .collect(Collectors.minBy(Comparator.comparingInt(String::length)));
//
//        collect.ifPresent(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
