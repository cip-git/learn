package oc.p._8._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.putIfAbsent;

import java.util.HashMap;
import java.util.Map;

import utils.print.Print;

/**
 * V put(K key, V value)
 *
 * default V putIfAbsent(K key, V value)
 *
 * If the specified key is not already associated with a value
 * (or is mapped to null) associates it with the given value and
 * returns null, else returns the current (old) value
 */
class PutIfAbsent {

    static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 1);
        map.put(2, 2);
    }

    static void m() {
        Print.print(map);

        System.out.println(map.putIfAbsent(3, null));  //null

        System.out.println(map.putIfAbsent(3, 3));  //null

        System.out.println(map.putIfAbsent(3, 33));  //3

        System.out.println(map.putIfAbsent(3, 3333));  //3

        Print.print(map);
    }

    public static void main(String[] args) {
        m();
    }
}
