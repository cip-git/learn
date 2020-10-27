package oc.p._11._4.functionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.methods.partitioningBy;

import static java.util.stream.Collectors.partitioningBy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import utils.print.Print;
import utils.resources.src.Src;

class R {

    static void m(){
        final Map<Boolean, List<Path>> collect = Src.Main.JAVA
                .get()
                .collect(partitioningBy(Files::isReadable));
        Print.print(collect);
    }

    static void m2(){
        final Map<Boolean, Map<Boolean, Map<Boolean, List<Path>>>> collect = Src.Main.JAVA
                .get()
                .collect(
                        partitioningBy(
                                Files::isDirectory,
                                partitioningBy(
                                        Files::isReadable,
                                        partitioningBy(Files::isWritable))));

        Print.print(collect);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
