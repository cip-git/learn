package oc.p._8._9_NIO2.interactingWithPathsAndFiles.pathObjects.usingPathSymbol;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class PathSymbol {

    static void m() throws IOException {
        Path p = Paths.get("");
        System.out.println(p);
        System.out.println(p.toAbsolutePath());
        System.out.println(p.toRealPath()); //throws an CE (IOE) if the path doesn't actually point to some file
        Path cd = Paths.get(".");
        System.out.println(cd);
        System.out.println(cd.toAbsolutePath());
        System.out.println(cd.toRealPath());

        Path pcd = Paths.get("..");
        System.out.println(pcd);
        System.out.println(pcd.toAbsolutePath());
        System.out.println(pcd.toRealPath());

        Path ppcd = Paths.get("..", "..");
        System.out.println(ppcd);
        System.out.println(ppcd.toAbsolutePath());
        System.out.println(ppcd.toRealPath());

        Path pppcd = Paths.get("..", "..", "..");
        System.out.println(pppcd);
        System.out.println(pppcd.toAbsolutePath());
        System.out.println(pppcd.toRealPath());


        Path pppcd2 = Paths.get("../../..");
        System.out.println(pppcd2);
        System.out.println(pppcd2.toAbsolutePath());
        System.out.println(pppcd2.toRealPath());

        Path pppcd3 = Paths.get("..\\..\\..");
        System.out.println(pppcd3);
        System.out.println(pppcd3.toAbsolutePath());
        System.out.println(pppcd3.toRealPath());
    }


    public static void main(String[] args) throws IOException {
        m();
    }
}
