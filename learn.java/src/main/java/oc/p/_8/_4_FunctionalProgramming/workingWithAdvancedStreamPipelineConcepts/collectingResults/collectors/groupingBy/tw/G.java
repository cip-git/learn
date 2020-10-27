package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.groupingBy.tw;

import static java.util.stream.Collectors.groupingBy;
import static utils.print.Print.print;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import utils.javaClass.PathOf;

class G {

    static Path path = PathOf.SRC_MAIN_JAVA.getValue();

    static void m() throws IOException {
        var collect = Files
                .find(path, Short.MAX_VALUE, (p, bfa) -> bfa.isRegularFile())
                .map(p -> p.getFileName())
                .collect(groupingBy(
                        p -> p.toString().charAt(0),
                        TreeMap::new,
                        groupingBy(
                                p -> p.toString().length(),
                                TreeMap::new,
                                Collectors.counting()
                        )));
        print(collect);
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
