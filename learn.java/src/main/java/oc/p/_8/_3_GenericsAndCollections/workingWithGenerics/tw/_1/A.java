package oc.p._8._3_GenericsAndCollections.workingWithGenerics.tw._1;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import utils.javaClass.hierrarchy.methods.alphabet.C;
import utils.javaClass.hierrarchy.methods.alphabet.E;
import utils.javaClass.hierrarchy.methods.alphabet.F;

class A {

    List raw = new ArrayList();
    List<Object> objs = new ArrayList<>();
    List<?> wildcard = new ArrayList<>();
    List<? extends E> upper = new ArrayList<>();
    List<? super E> lower = new ArrayList<>();
    List<E> es = new ArrayList<>();

    Object o;
    C c;
    E e;
    F f;
    ZonedDateTime zdt;


    void m12(){
        es.add(null);
//        es.add(o);
//        es.add(c);
        es.add(e);
        es.add(f);
//        es.add(zdt);
    }

    void m11(){
        lower.add(null);
//        lower.add(o);
//        lower.add(c);
        lower.add(e);
        lower.add(f);
//        lower.add(zdt);
    }

    void m10(){
        upper.add(null);
//        upper.add(o);
//        upper.add(c);
//        upper.add(e);
//        upper.add(f);
//        upper.add(zdt);
    }

    void m9(){
        wildcard.add(null);
//        wildcard.add(o);
//        wildcard.add(c);
//        wildcard.add(e);
//        wildcard.add(f);
//        wildcard.add(zdt);
    }


    void m8(){
        objs.add(null);
        objs.add(o);
        objs.add(c);
        objs.add(e);
        objs.add(f);
        objs.add(zdt);
    }

    void m7(){
        raw.add(null);
        raw.add(o);
        raw.add(c);
        raw.add(e);
        raw.add(f);
        raw.add(zdt);
    }

    void m6(){
        es = raw;
//        es = objs;
//        es = wildcard;
//        es = upper;
//        es = lower;
    }

    void m5(){
        lower = raw;
        lower = objs;
//        lower = wildcard;
//        lower = upper;
        lower = es;
    }


    void m4(){
        upper = raw;
//        upper = objs;
//        upper = wildcard;
//        upper = lower;
        upper = es;
    }

    void m3(){
        wildcard = raw;
        wildcard = objs;
        wildcard = upper;
        wildcard = lower;
        wildcard = es;
    }


    void m2() {
        objs = raw;
//        objs = wildcard;
//        objs = upper;
//        objs = lower;
//        objs = es;
    }


    void m() {
        raw = objs;
        raw = wildcard;
        raw = upper;
        raw = lower;
        raw = es;
    }

}
