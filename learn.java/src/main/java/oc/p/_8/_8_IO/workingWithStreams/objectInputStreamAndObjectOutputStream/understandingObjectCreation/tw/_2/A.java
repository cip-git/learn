package oc.p._8._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;

class A {

    static String varA = "A var";

    /**
     * The static initializer block isn't called, when the object is deserialize
     */
    static {
        System.out.println("static initializer A ");
    }

    {
        System.out.println("initializer A");
    }

    A() {
        System.out.println("constructor A");
    }

    @Override
    public String toString() {
        return "A";
    }
}
