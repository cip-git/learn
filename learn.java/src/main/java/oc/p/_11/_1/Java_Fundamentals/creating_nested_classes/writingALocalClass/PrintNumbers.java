package oc.p._11._1.Java_Fundamentals.creating_nested_classes.writingALocalClass;

class PrintNumbers {
    private int length = 5;

    {
        length = 50;
    }

    void comp(){
        final int width = 5;

        /**
         * The compiler is generating a .class file from your local class.
         * A separate class has no way to refer to local variables.
         * If the local variable is final, Java can handle it by passing it to the
         * constructor of the local class or by storing it in the .class file.
         * If it weren't effectively final, these tricks wouldn't work
         * because the value could change after the copy was made
         *
         */
        class Comp{
            static final String s = "Can be here, as well as in an inner class";
            int m(){
               return length+width;
            }
        }
        Comp c = new Comp();
        final int m = c.m();
        System.out.println(m);
    }
}
