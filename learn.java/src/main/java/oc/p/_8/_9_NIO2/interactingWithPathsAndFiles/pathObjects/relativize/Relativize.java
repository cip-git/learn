package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.relativize;

import utils.delimitators.Delimitators;
import utils.print.Print;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path	relativize(Path other)
 *
 * Constructs a relative path between this path and a given path.
 *
 * Beware
 * IllegalArgumentException when mixing absolute path with relative path
 */
class Relativize {

    static void m() {
        Path p = Paths.get("..", "..", "..", ".", "..", "q/w/e");
        Path p2 = Paths.get("a", ".", "s", "..", "d", "f");

        System.out.println(p);
        System.out.println(p2);

        System.out.println(p.normalize());
        System.out.println(p2.normalize());

        System.out.println(p.relativize(p2));  // ../../../../../../../../a/./s/../d/f
        System.out.println(p2.relativize(p));  // ../../../../../../../../.././../q/w/e
    }

    static void m2(){
        Path p = Paths.get("..", "..", "..", "a/b/c");
        Path p2 = Paths.get("../../../c/d/e");

        System.out.println(p);  // ../../../a/b/c
        System.out.println(p2);  // ../../../c/d/e
        System.out.println();

        System.out.println(p.normalize());
        System.out.println(p2.normalize());
        System.out.println();

        System.out.println(p.relativize(p2)); //
        System.out.println(p2.relativize(p));  //
    }

    static void m3(){
        Path p = Paths.get("E:\\a\\b");
        Path p2 = Paths.get("E://c//d");

        System.out.println(p);  // E:/a/b
        System.out.println(p2);  //E:/c/d

        System.out.println(p.relativize(p)); //
        System.out.println(p2.relativize(p2));  //
    }

    static void m4(){
        Path p = Paths.get("/", "a/b");
        Path p2 = Paths.get("/", "c/d");

        System.out.println(p);  // /a/b
        System.out.println(p2);  // /c/d

        System.out.println(p.relativize(p2));
        System.out.println(p2.relativize(p));
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
