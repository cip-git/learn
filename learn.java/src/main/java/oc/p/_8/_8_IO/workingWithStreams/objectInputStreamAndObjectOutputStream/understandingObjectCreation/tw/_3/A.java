package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._3;

import java.io.Serializable;

class A implements Serializable {

    static String a = am();

    static {
        System.out.println("A static init");
    }

    {
        System.out.println("A init");
    }

    A() {
        System.out.println("A constructor");
    }

    private static String am() {
        System.out.println("a");
        return "a";
    }
}
