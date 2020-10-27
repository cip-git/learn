package oc.p._8._3_GenericsAndCollections.comparatorVSComparable.tw;

import static utils.print.Print.print;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.javaClass.PathOf;
import utils.javaClass.hierrarchy.methods.alphabet.D;

class C {

    static void m() throws IOException {
        var var =  Files
                .find(
                        PathOf.SRC_MAIN_JAVA.getValue(),
                        Short.MAX_VALUE,
                        (p, bfa) -> bfa.isDirectory())
                .sorted(Comparator.comparing(p -> p.toString().length()).reversed())
                .map(p -> p.toString().length())
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList());
        print(var);
    }

    static void m2() throws IOException {
        var var = Files
                .find(
                        PathOf.SRC_MAIN_JAVA_GTK.getValue(),
                        Short.MAX_VALUE,
                        (p, bfa) -> bfa.isDirectory())
                .map(p -> p.getFileName().toString().charAt(0))
                .sorted(Comparator.reverseOrder())
                .distinct()
                .reduce("", (s, c) -> s+ c, String::concat);
        print(var);
    }

    static void m3() throws IOException {
        Files
                .find(
                        PathOf.SRC_MAIN_JAVA_GTK.getValue(),
                        Short.MAX_VALUE,
                        (p, bfa) -> bfa.isRegularFile())
                .sorted(Comparator.comparingInt(Path::getNameCount).reversed().reversed().reversed())
                .map(Path::getNameCount)
                .sorted(Comparator.reverseOrder())
                .reduce(Integer::sum)
                .ifPresentOrElse(System.out::println, () -> {});
    }

    static void m4(){
        var var = Stream
                .of(new D(), new D(), new D())
                .sorted(Comparator.comparingInt(o -> o.hashCode()).reversed())
                .map(Objects::hashCode)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        print(var);
    }

    public static void main(String[] args) throws IOException {
//        m();
//        m2();
//        m3();
        m4();
    }
}
