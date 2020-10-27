package oc.p._8._1_AdvancedClassDesign.review.q._17;

import utils.print.Print;

enum SetEnum {
    A(1, "a"),
    B(2, "b"),
    C(3, "c");

    /*final*/ int nb;
    String s;

    SetEnum(final int nb, final String s) {
        this.nb = nb;
        this.s = s;
    }

    static void print() {
        for (SetEnum setEnum : values()) {
            System.out.println(setEnum + ": " + setEnum.nb + ", " + setEnum.s);
        }
        Print.Delimitators.equal();
    }
}

class ModifyEnum {

    static void m() {
        SetEnum.print();

        for (SetEnum setEnum : SetEnum.values()) {
            setEnum.nb += 100;  //compiler error if nb declared final
            setEnum.s = setEnum.s.toUpperCase();
        }

        SetEnum.print();
    }

    public static void main(String[] args) {
        m();
        SetEnum.print();
    }
}
