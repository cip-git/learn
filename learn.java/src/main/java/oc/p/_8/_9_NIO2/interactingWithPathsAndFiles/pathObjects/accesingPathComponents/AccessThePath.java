package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.accesingPathComponents;

import oc.p._8._9_NIO2.util.TestPath;
import utils.print.Print;

import java.nio.file.Path;
import java.util.function.UnaryOperator;

/**
 * Path	getFileName()
 * <p>
 * Path	getParent()
 * <p>
 * Path	getRoot()
 */
class AccessThePath {
    static void m(UnaryOperator <Path> op) {
        TestPath.map()
                .forEach((k, v)-> System.out.println(k + " -> " + op.apply(v)));
        Print.Delimitators.equal();
    }

    static void getFileName() {
        System.out.println("Path::getFileName");
        m(Path::getFileName);
    }

    static void getParent() {
        System.out.println("Path::getParent");
        m(Path::getParent);
    }

    static void getRoot() {
        System.out.println("Path::getRoot");
        m(Path::getRoot);
    }

    public static void main(String[] args) {
        getFileName();
        getParent();
        getRoot();
    }
}
