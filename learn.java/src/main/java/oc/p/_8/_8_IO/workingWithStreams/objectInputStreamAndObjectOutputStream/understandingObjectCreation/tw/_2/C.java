package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;


import java.io.Serializable;

class C extends B implements Serializable {
    static String varC = "C var";

    static {
        System.out.println("static initializer C");
    }

    {
        System.out.println("initalizer C");
    }

    C() {
        System.out.println("constructor C");
    }


    @Override
    public String toString() {
        return "C";
    }
}
