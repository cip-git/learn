package oc.p._11._2.Annotations.review_questions;

class Qs {

    Qs(){
        class A{

        }

//        enum E{}  //compiler error: enums must not be local
    }

    @Q9("q9")
    void m9(){

    }

    static void m(){
    }
}

@interface Q9{
    String value() default "q9";

    String s()  default "";
}
