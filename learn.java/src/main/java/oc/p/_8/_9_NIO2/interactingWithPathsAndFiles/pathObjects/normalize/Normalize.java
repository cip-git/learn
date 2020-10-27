package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.normalize;

import oc.p._8._9_NIO2.util.TestPath;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path	normalize()
 *
 * Returns a file that is this file with redundant name elements eliminated.
 */
class Normalize {
    static Path wd  = TestPath.WORKING_DIR;

    static void m(){
        Path p = Paths.get(wd.toString(), ".", "..", ".", "..");
        System.out.println(p);

        p.normalize();
        System.out.println(p);


        p = p.normalize();
        System.out.println(p);
    }

    static void m2(){
        Path p  = Paths.get("a", ".", "b\\c", "d/e", "..", "f", "..", ".", "../..");
        System.out.println(p);
        System.out.println(p.normalize());
    }

    static void m3(){
        Path p = Paths.get("..", "..", "..", "a", "b", "c");
        System.out.println(p);
        System.out.println(p.normalize());
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
