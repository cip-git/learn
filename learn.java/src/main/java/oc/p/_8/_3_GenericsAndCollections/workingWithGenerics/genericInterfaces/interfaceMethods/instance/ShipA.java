package oc.p._8._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance;

import utils.javaClass.hierrarchy.methods.alphabet.E;

class ShipA implements Ship <E> {

    @Override
    public E m(final E e) {
        return null;
    }

    @Override
    public <T> T m2(final T t) {
        return null;
    }

    @Override
    public <T, Q> T m3(final T t, final Q q) {
        return null;
    }
}
