package oc.p._11._1.Java_Fundamentals.creating_nested_classes.tw;

class Outer {

    class Inner {

        static final int i = 1;
//        static final void m(){}
    }

    I i = new I(){
        static final int i  = 1;
//        static final void m(){}

    };

    static class StaticInner{

        static final int i  = 1;

        static final void m(){}
    }


    void m(){
        class Local{
            private String s = "";
            static final int i = 1;
//            static final void m(){}
        }
    }



    public static void main(String[] args) {
        final var outer = new Outer();

        new Outer().new Inner();
        outer.new Inner();

        new Outer.StaticInner();
    }
}
