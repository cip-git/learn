package oc.p._11._1.Java_Fundamentals.applying_the_final_modifier.final_class;

final class R {
}

//class Snake extends R{ }  //compiler error

final class A {
    final class B {
        final class C {
        }
    }
}

//final interface I{}