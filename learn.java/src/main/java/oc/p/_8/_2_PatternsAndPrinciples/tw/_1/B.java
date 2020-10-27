package oc.p._8._2_PatternsAndPrinciples.tw._1;

class B {

    static final int b /*= 1*/;

    static {
        b = 2;
    }

    B() {
//        b = 3;  //Compiler error
    }

    static void m() {
//        b = 4;  //Compiler error
    }
}
