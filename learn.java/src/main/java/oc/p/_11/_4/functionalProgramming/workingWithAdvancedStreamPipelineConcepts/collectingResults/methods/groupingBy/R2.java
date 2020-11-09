package oc.p._11._4.functionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.methods.groupingBy;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

import java.nio.file.Path;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import utils.print.Print;
import utils.resources.src.Src;

class R2 {

    static void m(){
        final TreeMap<String, Set<Path>> collect = Src.Main.JAVA
                .get()
                .collect(
                        groupingBy(
                                p -> p.getFileName().toString(),
                                TreeMap::new,
                                Collectors.toSet()));
        Print.print(collect);
    }

    public static void main(String[] args) {
        m();
    }
}
