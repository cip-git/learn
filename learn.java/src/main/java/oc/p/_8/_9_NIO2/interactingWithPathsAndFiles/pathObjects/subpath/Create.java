package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.subpath;

import oc.p._8._9_NIO2.util.TestPath;
import utils.print.Print;

import java.util.stream.IntStream;


/**
 * Path subpath(int beginIndex, int endIndex)  // endIndex: not included
 *
 * Returns a relative Path that is a subsequence of the name elements of this file
 */
class Create {
    static void m() {
        TestPath.map()
                .forEach((k, v) -> {
                    System.out.println(k);
                    IntStream.rangeClosed(1, v.getNameCount())
                            .forEach(i -> System.out.println(v.subpath(0, i)));
                    Print.Delimitators.equal();
                });
    }

    public static void main(String[] args) {
        m();
    }

}
