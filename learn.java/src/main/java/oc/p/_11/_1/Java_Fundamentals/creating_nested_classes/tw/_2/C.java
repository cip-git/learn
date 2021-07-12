package oc.p._11._1.Java_Fundamentals.creating_nested_classes.tw._2;

class C extends B{

    @Override
    void m() {
        System.out.println("C");
        super.m();
//        super.A.m();
    }

    public static void main(String[] args) {
        new C().m();
    }
}
