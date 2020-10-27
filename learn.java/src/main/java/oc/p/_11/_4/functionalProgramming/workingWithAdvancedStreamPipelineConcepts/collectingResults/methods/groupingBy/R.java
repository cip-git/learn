package oc.p._11._4.functionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.methods.groupingBy;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.TreeMap;

import utils.print.Print;
import utils.resources.src.Src;

class R {

    static void m() {
        final TreeMap<String, TreeMap<Integer, TreeMap<Boolean, Long>>> collect = Src.Main.JAVA
                .get()
                .collect(
                        groupingBy(
                                p -> p.getFileName().toString(),
                                TreeMap::new,
                                groupingBy(
                                        p -> p.getNameCount(),
                                        TreeMap::new,
                                        groupingBy(
                                                p -> p.isAbsolute(),
                                                TreeMap::new,
                                                counting()))
                        ));

        Print.print(collect);
    }

    public static void main(String[] args) {
        m();
    }

}
