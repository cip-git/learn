package oc.p._11._4.functionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.methods.toMap;

import static java.util.stream.Collectors.toMap;

import java.util.TreeMap;

import utils.print.Print;
import utils.resources.src.Src;

class ToMap {

    public static void main(String[] args) {
        m();
    }

    static void m() {
        final TreeMap<String, String> collect = Src.Main.JAVA
                .get()
                .collect(
                        toMap(
                                p -> p.getFileName().toString(),
                                p -> p.toString(),
                                (s, s2) -> s + ", " + s2,
                                TreeMap::new));
        Print.print(collect);
    }

}