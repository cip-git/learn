package oc.p._11._1.Java_Fundamentals.creating_nested_classes.tw;

import java.util.Comparator;

class A {

    class NestedClass{}

    static class StaticNestedClass{}

    static void localClasses(){
        class LocalClass{}

//        interface IL{ }  //not allowed here

//        enum EL {}  //not allowed here

        class LC2 extends LocalClass{

        }
    }

    static Comparator<Integer> anonymousClass = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    };

    static A anonymousClass2 = new A(){
        void m2(){}
    };
}
