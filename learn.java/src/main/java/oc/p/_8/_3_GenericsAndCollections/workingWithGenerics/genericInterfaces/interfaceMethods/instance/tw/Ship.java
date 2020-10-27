package oc.p._8._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance.tw;

import utils.javaClass.hierrarchy.methods.alphabet.E;

import java.time.LocalDate;

class Ship<T> {

    void m() {
        System.out.println("m");
    }

    <T> void m2(T t) {
        System.out.println("m2");
    }

    static class StaticClass {
        public static void main(String[] args) {
            Ship.A a = new Ship().new A();
            a = new Ship<>().new A();
            a = new Ship<Long>().new A();
            a = new Ship<E>().new A();

            a.m();

            a.<LocalDate>m2(LocalDate.now());
            a.m2(LocalDate.now());
        }
    }

    class A extends Ship <E> {
        @Override
        void m() {
            super.m();
        }

        @Override
        <T> void m2(final T t) {
            super.m2(t);
        }
    }

}
