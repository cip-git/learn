package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.collectingResults.collectors.joining;

import utils.javaClass.PathOf;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static utils.print.Print.print;

/**
 * static Collector<CharSequence,?,String>	joining()
 * Returns a Collector that concatenates the input elements into a String, in encounter order.
 *
 *
 * static Collector<CharSequence,?,String>	joining(CharSequence delimiter)
 * Returns a Collector that concatenates the input elements, separated by the specified delimiter, in encounter order.
 *
 *
 *
 * CharSequence known implementations: CharBuffer, Segment, String, StringBuffer, StringBuilder
 */
class Joining {

    static void m() throws IOException {
        var var = Files
                .find(
                        PathOf.SRC_MAIN_JAVA.getValue(),
                        Short.MAX_VALUE,
                        (p, bfa) -> bfa.isRegularFile() &&  p.getFileName().toString().endsWith(".jpg"))
                .map(p -> String.valueOf(p.getFileName().toString().charAt(0)))
                .distinct()
                .sorted()
                .collect(Collectors.joining(
                        " - ",
                        "Start: ",
                        " :End"
                ));
        print(var);
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
