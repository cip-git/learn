package oc.p._11._1.Java_Fundamentals.introducing_functional_programming.tw.declaringFIwithObjectMethods;

@FunctionalInterface
interface A {

    void m();

    int hashCode();

    String toString();

    boolean equals(Object o);
}

//@FunctionalInterface
interface B{

    void m();

//    short hashCode();  //compiler error: incompatible return type

    String toString();

    boolean equals(Object o);

    boolean equal(Object o);

    boolean equals (Object o, Object o2);  //overloading
}

class ImpA implements A{
    @Override
    public void m() {

    }
}

class ImpB implements B{
    @Override
    public void m() {

    }

    @Override
    public boolean equal(Object o) {
        return false;
    }

    @Override
    public boolean equals(Object o, Object o2) {
        return false;
    }
}