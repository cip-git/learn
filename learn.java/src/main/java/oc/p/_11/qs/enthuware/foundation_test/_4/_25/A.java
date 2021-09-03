package oc.p._11.qs.enthuware.foundation_test._4._25;

class A {
    A() {
        print();
    }

    void print() {
        System.out.print("A ");
    }
}

class B extends A {
    int i = 4;

    public static void main(String[] args) {
        A a = new B();
        a.print();
    }

    void print() {
        System.out.print(i + " ");
    }
}