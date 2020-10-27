package oc.p._8._1_AdvancedClassDesign.review.q._17;

import utils.print.Print;

enum AnimalClasses {
    MAMMAL(true), FISH(Boolean.FALSE), BIRD(false);
    boolean hashair;

    AnimalClasses(final boolean hashair) {
        this.hashair = hashair;
    }

    static void print() {
        for (AnimalClasses ac : values()) {
            System.out.println(ac + " -> " + ac.isHashair());
        }
        Print.Delimitators.equal();
    }

    boolean isHashair() {
        return hashair;
    }

    void setHashair(final boolean hashair) {
        this.hashair = hashair;
    }

    void set() {
        hashair = true;
    }
}

class A {
    static void m() {
        for (AnimalClasses ac : AnimalClasses.values()) {
            ac.set();
        }
    }
}

class B {
    static void m() {
        for (AnimalClasses ac : AnimalClasses.values()) {
            ac.setHashair(false);
        }
    }
}

class C {
    static void m() {
        AnimalClasses.print();

        A.m();
        AnimalClasses.print();

        B.m();
        AnimalClasses.print();
    }

    public static void main(String[] args) {
        m();
    }
}
