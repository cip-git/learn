package oc.p._11._1.Java_Fundamentals.creating_nested_classes.declaringAnInnerClass;

import oc.a.chapters._5_class_design.introducingClassInheritance.inheritingMethods.overridingAMethod.ownEx.O;

/**
 * Can be declared public, protected, package-private (default), or private
 * Can extend any class and implement interfaces Can be marked abstract or final
 * Cannot declare static fields or methods, except for static final fields
 * Can access members of the outer class including private members
 */
class Outer {

    private String greeting = "Hi";

    public static void main(String[] args) {
        final Outer outer = new Outer();
        outer.callInner();

        Outer.Inner oi = new Outer().new Inner();
        oi.m();
        oi = outer.new Inner();

    }

    void callInner() {
        Inner i = new Inner();
        i.m();
    }

    protected class Inner {
        static final int a = 2;  //only this is allowed

        //        static int a = 2;
//        static void m(){}
        protected int repeat = 3;

        void m() {
            for (int i = 0; i < repeat; i++) {
                //both ok
//                System.out.println(greeting);
                System.out.println(Outer.this.greeting);
            }

        }
    }
}
