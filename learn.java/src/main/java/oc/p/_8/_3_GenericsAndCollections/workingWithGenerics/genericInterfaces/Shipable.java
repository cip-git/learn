package oc.p._8._3_GenericsAndCollections.workingWithGenerics.genericInterfaces;

import utils.javaClass.hierrarchy.methods.alphabet.E;

interface Shipable<T> {

    void ship(T t);
}

class ShipableRaw implements Shipable {
    @Override
    public void ship( Object o) {
    }
}

class ShipableSpecifiedType implements Shipable <E> {
    @Override
    public void ship(final E e) {
    }
}

class ShipableAnotherGenericType<U> implements Shipable <U> {
    @Override
    public void ship(final U u) {

    }
}