package oc.p._11._1.Java_Fundamentals.applying_the_final_modifier.final_methods;

abstract class A {

    abstract void chew();
}

class Hipo extends A{
    @Override
    final void chew() {
    }
}