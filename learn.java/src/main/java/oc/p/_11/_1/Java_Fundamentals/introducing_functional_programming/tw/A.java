package oc.p._11._1.Java_Fundamentals.introducing_functional_programming.tw;

@FunctionalInterface
interface A {

    void m();
}

@FunctionalInterface
interface B {
    void m();
}

@FunctionalInterface
interface C extends A, B {
}
