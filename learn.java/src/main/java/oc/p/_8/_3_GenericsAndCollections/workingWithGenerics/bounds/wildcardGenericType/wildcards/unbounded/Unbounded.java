package oc.p._8._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.unbounded;

import utils.javaClass.hierrarchy.methods.alphabet.E;

import java.util.List;


class Unbounded {

    List raw;
    List <?> unbounded;
    List <Object> os;
    List <E> es;
    List <Runnable> rs;

    Object o;
    E e;
    Runnable r;

    void m4() {
//        unbounded.add(o);
//        unbounded.add(e);
//        unbounded.add(r);
    }

    void m3() {
        raw.add(o);
        raw.add(e);
        raw.add(r);
    }

    void m2() {
        unbounded = raw;
        unbounded = os;
        unbounded = es;
        unbounded = rs;
    }

    void m() {
        raw = unbounded;
        raw = os;
        raw = es;
        raw = rs;
    }

}
