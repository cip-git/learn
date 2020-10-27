package oc.p._11._1.Java_Fundamentals.creating_nested_classes.creatingAStaticNestedClass;

class Outer {

    static void m(){
        final int a = InnerStaticClass.a;
        InnerStaticClass.m();
    }

    static class InnerStaticClass{

        static int a;
        static void m(){}
        static final int b = 23;
    }

}
