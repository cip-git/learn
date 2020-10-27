package oc.p._11._1.Java_Fundamentals.understanding_interface_members.defaultMethods.tw;

interface I {

    default void m(){
        System.out.println("Im");
    }

}

interface I2 extends I {
    void m();
}

class C implements I, I2{

    @Override
    public void m() {
    }
}

interface I3 extends I, I2{

}

abstract class C2 implements I, I2, I3{

}