package oc.p._8._3_GenericsAndCollections.workingWithGenerics.bounds.tw;

import utils.javaClass.hierrarchy.methods.alphabet.D;
import utils.javaClass.hierrarchy.methods.alphabet.E;
import utils.javaClass.hierrarchy.methods.alphabet.F;

import java.time.LocalDate;

class Array {

    Object[] oa;
    D[] da;
    E[] ea;
    F[] fa;
    LocalDate[] lda;

    Object o;
    D d;
    E e;
    F f;
    LocalDate ld;

    void m10() {
        lda[0] = (LocalDate) o;
//        lda[1] = (LocalDate) d;
//        lda[2] = (LocalDate) e;
//        lda[3] = (LocalDate)f;
        lda[4] = ld;
    }

    void m9() {
        fa[0] = (F) o;
        fa[1] = (F) d;
        fa[2] = (F) e;
        fa[3] = f;
//        fa[4] = (F)ld;
    }

    void m8() {
        ea[0] = (E) o;
        ea[1] = (E) d;
        ea[2] = e;
        ea[3] = f;
//        ea[4] = (E)ld;
    }

    void m7() {
        da[0] = (D) o;
        da[1] = d;
        da[2] = e;
        da[3] = f;
//        da[4] = (D)ld;
    }

    void m6() {
        oa[0] = o;
        oa[1] = d;
        oa[2] = e;
        oa[3] = f;
        oa[4] = ld;
    }

    void m5() {
        lda = (LocalDate[]) oa;
//        lda = (LocalDate[]) da;
//        lda = (LocalDate[])ea;
//        lda = (LocalDate[])fa;
    }

    void m4() {
        fa = (F[]) oa;
        fa = (F[]) da;
        fa = (F[]) ea;
//        fa = (F[])lda;
    }

    void m3() {
        ea = (E[]) oa;
        ea = (E[]) da;
        ea = fa;
//        ea = (E[])lda;
    }

    void m2() {
        da = (D[]) oa;
        da = ea;
        da = fa;
//        da = (D[])lda;
    }

    void m() {
        oa = da;
        oa = ea;
        oa = fa;
        oa = lda;
    }
}
