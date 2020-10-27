package oc.p._8._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.ifPresent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import utils.print.Print;

/**
 * computeIfPresent() calls the BiFunction if the requested key is found and the associated value is not null
 *
 * default V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
 *  If the value for the specified key is present and non-null,
 *  attempts to compute a new mapping given the key and its current mapped value.
 *
 */
class ComputeIfPresent {

    static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.putIfAbsent(1, 1);
        map.putIfAbsent(2, 2);
    }

    static BiFunction<Number, Number, Integer> BF = (n, n2) -> n.intValue() + n.intValue();
    static BiFunction<Number, Number, Integer> NULL = (n, n2) -> null;

    static void m(){
        System.out.println(map.computeIfPresent(2, BF));  //4

        System.out.println(map.computeIfPresent(3, BF));  //null

        System.out.println(map.computeIfPresent(2, NULL));  //null; element eliminated

        Print.print(map);
    }

    static void m2(){
        map.computeIfPresent(2, null);  //NPE
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
