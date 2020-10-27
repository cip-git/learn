package oc.p._8._1_AdvancedClassDesign.creatingNestedClasses.tw._1.inheritance;

class A {
    int i = 0;
    String a = "A";

    void m(){
        System.out.println(i);
        System.out.println(this.i);
        System.out.println(A.this.i);
        System.out.println(A.this.a);
    }
}

class B extends A {
    int i = 1;
    String b = "B";

    void m(){
        System.out.println(super.i);
        System.out.println(super.a);
        System.out.println(this.i);
        System.out.println(this.a);
        System.out.println(this.b);
    }
}

class C extends B {
    int i = 2;
    String c = "C";

    void m(){
        System.out.println(super.i);
        System.out.println(this.i);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

class R{

    public static void main(String[] args) {
//        new B().m();
       new C().m();
    }
}