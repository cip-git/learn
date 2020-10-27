package oc.p._8._3_GenericsAndCollections.workingWithGenerics.genericClasses;

import utils.javaClass.hierrarchy.methods.alphabet.E;

/**
 * Type Erasure
 * Specifying a generic type allows the compiler to enforce proper use of the generic type.
 * For example, specifying the generic type of Crate as E is like replacing the T in the
 * Crate class with E. However, this is just for compile time.
 * Behind the scenes, the compiler replaces all references to T in Crate with Object. In other
 * words, after the code compiles, your generics are actually just Object types.
 */
class TypeErasure {

    public static void main(String[] args) {
        Crate <E> cr = new Crate <>();
        cr.pack(new E());
        E e = cr.unPack();
        /*
        Behind the scene, the cast is automatically done
        Robot r = (Robot)cr.unPack ();
         */

//        cr.pack ( new Integer(2) );  //compiler error
//        cr = new Crate<Integer> ();  //compiler error

        Crate <Integer> ce = new Crate <>();
        ce.pack(new Integer(2));
        Integer i = ce.unPack();
    }

}
