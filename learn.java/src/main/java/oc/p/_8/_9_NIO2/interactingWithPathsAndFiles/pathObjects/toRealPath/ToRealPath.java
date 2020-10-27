package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.toRealPath;

import oc.p._8._9_NIO2.util.TestPath;
import utils.print.Print;

import java.io.IOException;

/**
 * Path	toRealPath(LinkOption... options)
 *
 * Returns the real path of an existing file.
 *
 * Remember:
 * Paths.get("") and Paths.get(".") point to the working dir
 */
class ToRealPath {

    static void m() {
        TestPath.map()
                .forEach((k, v) ->
                {
                    System.out.println(k);
                    try {
                        System.out.println(v.toRealPath());
                    } catch (IOException e) {
                        System.out.println(" is relative");
                    }
                    Print.Delimitators.equal();
                });
    }

    public static void main(String[] args) {
        m();
    }

}
