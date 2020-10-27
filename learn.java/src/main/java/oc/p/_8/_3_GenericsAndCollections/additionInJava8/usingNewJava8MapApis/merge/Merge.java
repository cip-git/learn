package oc.p._8._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.merge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import utils.print.Print;

/**
 * default V merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
 *
 * If the specified key is not already associated with a value or
 * is associated with null, associates it with the given non-null value.
 */
class Merge {
    static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.putIfAbsent(1, 1);
        map.putIfAbsent(2, 2);
    }

    static BiFunction<Integer, Number, Integer> BF = (n, n2) -> n + n2.intValue();
    static BiFunction<Integer, Number, Integer> NULL = (n, n2) -> null;

    static void m(){
        System.out.println(map.merge(3, 3, BF));  //3
        System.out.println(map.merge(3, 3, BF));  //6
    }

    static void m2(){
        System.out.println(map.merge(3, 3, NULL));  //3
        System.out.println(map.merge(3, 3, NULL));  //null, remove element
        Print.print(map);
    }

    static void m3(){
        map.merge(3, null, BF);  //RE
    }

    static void m4(){
        map.merge(3, 3, null);  //RE
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
