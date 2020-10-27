package oc.p._11._1.Java_Fundamentals.review_questions;

import java.util.function.BiConsumer;
import java.util.function.Predicate;

class Q20 {

    static int staticInstVar = 1;

    static {
        staticInstVar = 2;
    }

    int instVar = 1;
    Predicate<Integer> p = i -> instVar < 22;

    {
        instVar = 2;
    }

    void m() {
        final int iv = instVar = 3;
        int siv = staticInstVar = 3;

        class A {
            static final String a = "a";

            {
                staticInstVar = 4;
                instVar = 4;
            }

            void m(){
                staticInstVar = 5;
                instVar = 5;
            }
        }
        new A().m();
    }

    void print(){
        System.out.println(staticInstVar);
        System.out.println(instVar);
    }

    BiConsumer<Integer, Integer> bc = (i, i2) -> {
        staticInstVar = 6;
        instVar = 6;
        System.out.println(i);
        System.out.println(i2);
    };

    public static void main(String[] args) {
        var var = new Q20();
        var.print();
        var.m();
        var.print();
        var.bc.accept(var.instVar, var.staticInstVar);
    }
}
