package oc.p._11._4.functionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.methods.groupingBy;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import utils.print.Print;
import utils.resources.src.Src;

class R {

    static void m(){
        final Map<Boolean, List<Path>> collect = Src.Main.JAVA
                .get()
                .collect(groupingBy(Files::isDirectory));

        collect
                .get(true)
                .forEach(System.out::println);
    }

    static void m2(){
        final Map<Boolean, Map<Integer, Map<Boolean, List<Path>>>> a = Src.Main.JAVA
                .get()
                .collect(
                        groupingBy(
                                Files::isDirectory,
                                groupingBy(
                                        p -> p.getNameCount(),
                                        groupingBy(p -> p.getFileName().toString().startsWith("a")))));

        Print.print(a.get(true).get(7));
    }

    static void m3(){
        final TreeMap<Integer, Set<Path>> collect = Src.Main.JAVA
                .get()
                .collect(
                        groupingBy(
                                p -> p.getNameCount(),
                                TreeMap::new,
                                toSet()));
        Print.print(collect);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
