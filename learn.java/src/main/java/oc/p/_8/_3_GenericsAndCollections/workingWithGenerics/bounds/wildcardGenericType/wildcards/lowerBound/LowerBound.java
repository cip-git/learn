package oc.p._8._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.lowerBound;

import utils.javaClass.hierrarchy.methods.alphabet.D;
import utils.javaClass.hierrarchy.methods.alphabet.E;
import utils.javaClass.hierrarchy.methods.alphabet.F;

import java.util.List;

class LowerBound {

    List <? super E> lowerBound;
    List <D> ds;
    List <E> es;
    List <F> fs;
    List <Runnable> rs;

    D d;
    E e;
    F f;
    Runnable r;

    void m() {
        lowerBound = ds;
        lowerBound = es;
//        lowerBound = fs;
//        lowerBound = rs;
    }

    void m2() {
//        lowerBound.add(d);
        lowerBound.add(e);
        lowerBound.add(f);
//        lowerBound.add(r);
    }
}
