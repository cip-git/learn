package oc.p._8._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.upperBound;

import utils.javaClass.hierrarchy.methods.alphabet.D;
import utils.javaClass.hierrarchy.methods.alphabet.E;
import utils.javaClass.hierrarchy.methods.alphabet.F;

import java.util.List;

class UpperBound {

    List <? extends E> upperBound;
    List <D> ds;
    List <E> es;
    List <F> fs;
    List <Runnable> rs;

    D d;
    E e;
    F f;
    Runnable r;

    void m() {
//        upperBound = ds;
        upperBound = es;
        upperBound = fs;
//        upperBound = rs;
    }

    void m2() {
//        upperBound.add(d);
//        upperBound.add(e);
//        upperBound.add(f);
//        upperBound.add(r);
    }

}
