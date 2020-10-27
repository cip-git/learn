package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._3;

import java.io.Serializable;

class C extends B implements Serializable {

    static String c = cm();

    static {
        System.out.println("C static init");
    }

    {
        System.out.println("C init");
    }

    C() {
        System.out.println("C constructor");
    }

    private static String cm() {
        System.out.println("c");
        return "c";
    }
}
