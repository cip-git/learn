package oc.p._11._1.Java_Fundamentals.creating_nested_classes.tw._2;

class R {

    class  A{
    }

    static class B{
    }

    void m(){
        new A();
        new B();

        new R().new A();

        new R.A();
        new R.B();
    }
}
