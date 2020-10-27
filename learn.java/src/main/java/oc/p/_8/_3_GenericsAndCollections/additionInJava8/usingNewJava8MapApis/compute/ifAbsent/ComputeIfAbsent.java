package oc.p._8._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.ifAbsent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import utils.print.Print;

/**
 * default V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
 * If the specified key is not already associated with a value
 * (or is mapped to null), - putIfAbsent
 * attempts to compute its value using the given mapping function and enters
 * it into this map unless null.
 *
 * computeIfAbsent(), calls the BiFunction  only when the key isn’t present or is null
 */
class ComputeIfAbsent {
    static Map<Integer, Integer> map = new HashMap<>();

    static{
        map.putIfAbsent(1, 1);
        map.putIfAbsent(2, 2);
    }

    static Function<Integer, Integer> F = i -> i*i;
    static Function<Integer, Integer> NULL = i -> null;

    static void m(){
        Print.print(map);
        System.out.println(map.computeIfAbsent(3, F));  //9

        System.out.println(map.putIfAbsent(4, null));  //null

        System.out.println(map.computeIfAbsent(4, F));  //16

        Print.print(map);
    }

    static void m2(){
        System.out.println(map.computeIfAbsent(3, NULL));  //null; is not added

        Print.print(map);
    }

    static void m3(){
        map.computeIfAbsent(3, null);  //NPE
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
