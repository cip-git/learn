package oc.p._11._1.Java_Fundamentals.creating_nested_classes.writingALocalClass;

import java.io.Closeable;
import java.io.IOException;
import java.util.Comparator;

import oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.A;
import oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.C;
import utils.javaClass.hierrarchy.methods.alphabet.E;

class Outer {

    static {
        class LC{
            static final int a = 1;
        }

//        static class LC2{}  //static not allowed here

//        interface I{}  //not allowed here

//        enum E{}  //not allowed here

    }

    {
        class LC{
            static final int a = 1;
        }

//        static class SLC{}  //static not allowed here

//        interface I{}

//        enum E{}
    }

    static void sm(){
        class LC{}

//        static class SLC{}
    }

    void m(){
        int b = 2;
        class LC extends E implements Closeable, Comparator<E> {
            static final int a = 1;
            @Override
            public void close() throws IOException {
                //have access to local variables if the variables are final or effective final
                System.out.println(b);
            }

            @Override
            public int compare(E o1, E o2) {
                return 0;
            }
        }
    }
}
