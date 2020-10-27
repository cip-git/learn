package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.checkingPathType;

import oc.p._8._9_NIO2.util.TestPath;
import utils.print.Print;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * boolean	isAbsolute()
 *
 * Path	toAbsolutePath()
 */
class Check {

    static Predicate <Path> isAbsolute = Path::isAbsolute;
    static UnaryOperator <Path> toAbsolutePath = Path::toAbsolutePath;

    static void m() {
        TestPath.map()
                .forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(v);
                    System.out.println("isAbsolute: " + isAbsolute.test(v));
                    System.out.println("toAbsolutePath: " + toAbsolutePath.apply(v));
                    Print.Delimitators.newLine();
                });
    }

    public static void main(String[] args) {
        m();
    }
}
