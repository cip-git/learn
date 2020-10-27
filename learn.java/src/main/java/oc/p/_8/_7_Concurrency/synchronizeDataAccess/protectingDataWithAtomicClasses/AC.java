package oc.p._8._7_Concurrency.synchronizeDataAccess.protectingDataWithAtomicClasses;

import utils.javaClass.hierrarchy.methods.alphabet.E;

import java.util.concurrent.atomic.*;

class AC {

    {
        AtomicBoolean ab = new AtomicBoolean(false);
        System.out.println(ab);
        System.out.println(ab.get());
    }

    {
        AtomicInteger ai = new AtomicInteger(2);
        System.out.println(ai);

        AtomicIntegerArray aia = new AtomicIntegerArray(new int[]{1, 2, 3});
        System.out.println(aia);
    }

    {
        AtomicLong al = new AtomicLong(7);
        System.out.println(al);

        AtomicLongArray ala = new AtomicLongArray(new long[]{4, 5, 6});
        System.out.println(ala);
    }

    {
        AtomicReference <E> ar = new AtomicReference <>(new E());
        System.out.println(ar);

        AtomicReferenceArray <E> ara = new AtomicReferenceArray <E>(new E[]{new E()});
        System.out.println(ara);
    }

    public static void main(String[] args) {
        new AC();
    }

}
