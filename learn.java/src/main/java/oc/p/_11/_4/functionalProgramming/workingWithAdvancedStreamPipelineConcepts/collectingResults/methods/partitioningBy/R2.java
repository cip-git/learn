package oc.p._11._4.functionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.methods.partitioningBy;

import static java.util.stream.Collectors.partitioningBy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import utils.print.Print;
import utils.resources.src.Src;

class R2 {

    static void m(){
        final Map<Boolean, Set<Path>> collect = Src.Main.JAVA
                .get()
                .collect(
                        partitioningBy(
                                Files::isRegularFile,
                                Collectors.toSet()
                        ));

        Print.print(collect);
    }

    public static void main(String[] args) {
        m();
    }
}
