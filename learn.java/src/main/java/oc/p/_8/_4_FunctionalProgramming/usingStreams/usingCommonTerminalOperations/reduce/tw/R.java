package oc.p._8._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.reduce.tw;

import static utils.print.Print.print;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import utils.resources.files.Location;

class R {

    static Path p = Path.of(Location.SRC_MAIN_JAVA.asPath(), "iq");

    static void m() throws IOException {
        final Optional<Integer> reduce = Files
                .walk(p)
                .map(p -> p.toString().length())
                .reduce((i, i2) -> i + i2);
        reduce.ifPresentOrElse(System.out::println, () -> System.out.println("No value here"));
    }

    static void m2() throws IOException {
        final Integer reduce = Files
                .walk(p)
                .map(p -> p.toString().length())
                .reduce(0, (i, i2) -> i + i2);
        print(reduce);
    }

    static void m3() throws IOException {
        final Integer reduce = Files
                .walk(p)
                .reduce(0, (i, p) -> p.toString().length() + i, (i, i2) -> i + i2);
        print(reduce);
    }

    public static void main(String[] args) throws IOException {
        m();
        m2();
        m3();
    }
}
