package oc.p._11._1.Java_Fundamentals.review_questions.tw;

interface I {
    default void m(){}
}

interface I2 extends I{
    default void m(){}
}

interface I3 extends I2{
    default void m(){}
}

interface I4 extends I, I2, I3{

}

abstract class C implements I, I2, I3, I4{

}
