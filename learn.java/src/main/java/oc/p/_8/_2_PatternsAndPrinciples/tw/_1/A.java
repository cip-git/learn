package oc.p._8._2_PatternsAndPrinciples.tw._1;

class A {

    final int a /*= 1*/;

    static{
//        a = 0;  //Compiler error: here a isn't visible
    }

    {
//        a = 2;
    }

    A() {
        this.a = 2;  //after this place a cannot be instantiated
    }

    void m(){
//        a = 4;  //Too late, plus the fact that a is final
    }

}
