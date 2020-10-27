package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.resolve;

import oc.p._8._9_NIO2.util.TestPath;
import utils.print.Print;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path	resolve(Path other)
 *
 * Path resolve(String other)
 *
 *
 * If the other parameter is an isAbsolute() absolute path then  returns other.
 *
 * If other is an empty path then returns this path.
 *
 * Otherwise this method considers this path to be a directory and resolves
 * the given path against this path.
 *
 * In the simplest case, the given path does not have a getRoot component, in which case this method
 * joins the given path to this path and returns a resulting path
 *
 * Where the given path has a root component then resolution is highly implementation dependent
 * and therefore unspecified.
 */
class Resolve {

    static void m() {
        TestPath.map()
                .forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(v.isAbsolute());
                    System.out.println(v.getRoot());
                });
    }

    static void rule1() {
        Path p = Paths.get("a");
        Path p2 = TestPath.WORKING_DIR;

        final Path resolve = p.resolve(p2);
        System.out.println(resolve);
        Print.Delimitators.equal();
    }

    static void rule2() {
        Path p = TestPath.WORKING_DIR;
        Path p2 = Paths.get("");

        System.out.println(p.resolve(p2));
        Print.Delimitators.equal();
    }

    static void rule3() {
        Path p = Paths.get("q", "w", "e");
        Path p2 = Paths.get("a", "s", "d");

        System.out.println(p.resolve(p2));
        System.out.println(p2.resolve(p));
    }

    public static void main(String[] args) {
//        m();

//        rule1();
//        rule2();
        rule3();
    }
}
