package oc.p._8._3_GenericsAndCollections.workingWithGenerics.bounds.tw;

import utils.javaClass.hierrarchy.methods.alphabet.D;
import utils.javaClass.hierrarchy.methods.alphabet.E;
import utils.javaClass.hierrarchy.methods.alphabet.F;

import java.util.List;

class Lists {

    List raw;
    List <?> wildcard;
    List <Object> os;
    List <E> es;
    List <? extends E> upperBound;
    List <? super E> lowerBound;

    Object o;
    D d = new D();
    E e = new E();
    F f = new F();

    void m12() {
//        lowerBound.add(o);
//        lowerBound.add(d);
        lowerBound.add(e);
        lowerBound.add(f);
    }

    void m11() {
//        upperBound.add(o);
//        upperBound.add(d);
//        upperBound.add(e);
//        upperBound.add(f);
    }

    void m10() {
//        es.add(o);
//        es.add(d);
        es.add(e);
        es.add(f);
    }

    void m9() {
        os.add(o);
        os.add(d);
        os.add(e);
        os.add(f);
    }

    void m8() {
//        wildcard.add(o);
//        wildcard.add(d);
//        wildcard.add(e);
//        wildcard.add(f);
    }

    void m7() {
        raw.add(o);
        raw.add(d);
        raw.add(e);
        raw.add(f);
    }

    void m6() {
        lowerBound = raw;
//        lowerBound = wildcard;
        lowerBound = os;
        lowerBound = es;
//        lowerBound = upperBound;
    }

    void m5() {
        upperBound = raw;
//        upperBound = wildcard;
//        upperBound = os;
        upperBound = es;
//        upperBound = lowerBound;
    }

    void m4() {
        os = raw;
//        os = wildcard;
//        os = es;
//        os = upperBound;
//        os = lowerBound;
    }

    void m3() {
        es = raw;
//        es = os;
//        es = wildcard;
//        es = upperBound;
//        es = lowerBound;
    }

    void m2() {
        wildcard = raw;
        wildcard = os;
        wildcard = es;
        wildcard = upperBound;
        wildcard = lowerBound;
    }

    void m() {
        raw = wildcard;
        raw = os;
        raw = es;
        raw = upperBound;
        raw = lowerBound;
    }

}
