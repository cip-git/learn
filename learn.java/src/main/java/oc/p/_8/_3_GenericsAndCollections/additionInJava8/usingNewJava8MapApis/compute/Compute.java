package oc.p._8._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import javax.print.attribute.standard.NumberUp;

import utils.print.Print;

/**
 * default V	compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
 * Attempts to compute a mapping for the specified key and its current mapped value (or null
 * if there is no current mapping).
 *
 * default V	computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
 * If the specified key is not already associated with a value (or is mapped to null),
 * attempts to compute its value using the given mapping function and enters it into this map unless null.
 *
 * default V	computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
 * If the value for the specified key is present and non-null,
 * attempts to compute a new mapping given the key and its current mapped value.
 */

class Compute{
    static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.putIfAbsent(1, 1);
        map.putIfAbsent(2, 2);
    }

    static BiFunction<Number, Integer, Integer> BF = (n, n2) -> n.intValue() + n2;
    static BiFunction<Number, Integer, Integer> BF_2 = (n, n2) -> n.intValue() + (n2 = n2 != null? n2: 0);
    static BiFunction<Number, Integer, Integer> NULL = (n, n2) -> null;

    static void m(){
        System.out.println(map.compute(2, BF));  //4

        map.compute(3, BF);  //RE
    }

    static void m2(){
        System.out.println(map.compute(3, BF_2));  //2;

        Print.print(map);
    }

    static void m3(){
        map.compute(2, NULL);  //null; element removed
        Print.print(map);
    }

    static void m4(){
        map.compute(2, null);  //RE
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }

}
