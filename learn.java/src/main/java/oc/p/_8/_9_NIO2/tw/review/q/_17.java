package oc.p._8._9_NIO2.tw.review.q;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class _17 {

    static  Path x = Paths.get("");
    static  Path dot = Paths.get(".");
    static  Path doubleDot = Paths.get("..");

    static void m(){
        System.out.println(x);
        System.out.println(dot);
        System.out.println(doubleDot);
        System.out.println();
    }

    static void m2(){
        System.out.println(x.normalize());
        System.out.println(dot.normalize());
        System.out.println(doubleDot.normalize());
    }

    static void m3(){
        System.out.println(x.toAbsolutePath());
        System.out.println(dot.toAbsolutePath());
        System.out.println(doubleDot.toAbsolutePath());
    }

    static void m4() throws IOException {
        System.out.println(x.toRealPath());
        System.out.println(dot.toRealPath());
        System.out.println(doubleDot.toRealPath());
    }

    static void m5(){
        System.out.println(x.toAbsolutePath().normalize());
        System.out.println(dot.toAbsolutePath().normalize());
        System.out.println(doubleDot.toAbsolutePath().normalize());
    }

    static void m6(){
        System.out.println(x.getNameCount());
        System.out.println(dot.getNameCount());
        System.out.println(doubleDot.getNameCount());
        System.out.println(x.getName(0));
        System.out.println(dot.getName(0));
        System.out.println(doubleDot.getName(0));

        System.out.println("====");

        System.out.println(x.normalize().getNameCount());  //o
        System.out.println(dot.normalize().getNameCount());  //0
        System.out.println(doubleDot.normalize().getNameCount());

        System.out.println(x.normalize().getName(0));
        System.out.println(dot.normalize().getName(0));
        System.out.println(dot.normalize().getName(0));
    }

    public static void main(String[] args) throws IOException {
//        m();
//        m2();
//        m3();
//        m4();
//        m5();
        m6();
    }
}
