package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._3;

import java.io.Serializable;

class B extends A implements Serializable {

    static String b = bm();

    static {
        System.out.println("B static init");
    }

    {
        System.out.println("B init");
    }

    B() {
        System.out.println("B constructor");
    }

    private static String bm() {
        System.out.println("b");
        return "b";
    }
}
