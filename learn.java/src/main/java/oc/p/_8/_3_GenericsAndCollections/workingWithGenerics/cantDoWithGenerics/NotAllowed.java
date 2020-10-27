package oc.p._8._3_GenericsAndCollections.workingWithGenerics.cantDoWithGenerics;

/**
 * Call the constructor. new T() is not allowed because at runtime it would be new Object().
 *
 *
 * Create an array of that static type. This one is the most annoying, but it makes sense
 * because you’d be creating an array of Objects.
 *
 *
 * Call instanceof. This is not allowed because at runtime List<Integer> and
 * List<String> look the same to Java thanks to type erasure.
 *
 *
 * Create a static variable as a generic type parameter. This is not allowed because the
 * type is linked to the instance of the class.
 *
 *
 * Use a primitive type as a generic type parameter. This isn’t a big deal because you
 * can use the wrapper class instead. If you want a type of int, just use Integer.
 */

class NotAllowed<T> {
    static {
        /**
         * Not allowed because the type T is bonded to the
         * instance of the class; not to the class itself
         * Crate<SomeType> c = new Crate<SomeType>()
         */
//	    T t;
    }
//	static T t;

    T t;

    {
//		t = new T();

//		T[] ts = new T[2];
//		T[] ts = new T[]{};
//		T[] ts = {t, t};
        T[] ts = (T[]) new Object[2];

        boolean b = t instanceof String;  //allowed but always returns false
        b = ts instanceof String[];
    }
}
