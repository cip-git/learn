package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;


import java.io.Serializable;

class B extends A implements Serializable {
    static String varB = "B var";

    static {
        System.out.println("static initializer B");
    }

    {
        System.out.println("initializer B");
    }

    public B() {
        System.out.println("constructor B");
    }

    @Override
    public String toString() {
        return "B";
    }
}
