package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.viewingThePath;


import utils.print.Print;
import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/**
 * String toString()
 *
 * int getNameCount()
 *
 * Path	getName(int index)
 *
 * Be aware that the
 * getName(int) method is zero-indexed
 * and drive letter not being taken into account
 *
 * getName(0) != getRoot()
 * getName(getNameCount() - 1) == getFileName();
 */
class ViewThePath {
    Path p = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(),
            this.getClass().getSimpleName());

    Path p2 = Paths.get("a", "b", "c");


    public static void main(String[] args) throws IOException {
        ViewThePath v = new ViewThePath();

        v.m();
        v.m2();
        v.m3();
        v.m4();
        v.m5();
    }

    void m5() throws IOException {
        Path p3 = Paths.get(p.toString(), ".");
        System.out.println(p3);
        System.out.println(p3.toAbsolutePath());
        System.out.println(p3.toRealPath());

        Path p4 = Paths.get(p.toString(), "..", "..");
        System.out.println(p4.toString());
        System.out.println(p4.toAbsolutePath());
        System.out.println(p4.toRealPath());
    }

    void m4(){
        final Path fileName = p.getFileName();
        System.out.println(fileName);

        final Path fileName2 = p2.getFileName();
        System.out.println(fileName2);
        Print.Delimitators.equal();
    }

    void m3(){
        IntStream.range(0, p.getNameCount()-1)
                .forEach(i-> System.out.println(p.getName(i)));
        Print.Delimitators.newLine();
        IntStream.range(0, p2.getNameCount())
                .forEach(i-> System.out.println(p2.getName(i)));
        Print.Delimitators.equal();
    }


    void m2(){
        final int nameCount = p.getNameCount();
        System.out.println(nameCount);

        final int nameCount2 = p2.getNameCount();
        System.out.println(nameCount2);
        Print.Delimitators.equal();
    }

    void m() {
        System.out.println(p);
        System.out.println(p.toString());

        System.out.println(p2);
        System.out.println(p2.toString());
        Print.Delimitators.equal();
    }
}
