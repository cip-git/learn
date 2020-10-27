package oc.p._8._3_GenericsAndCollections.additionInJava8.updatingAllElements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

/**
 * This method is specific to List interface and Map
 *
 * default void	replaceAll(UnaryOperator<E> operator)
 *
 * default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        */
class Lst {

    static void m() {
        List<String> lst = Arrays.asList("ana", "are", "ananas");
        lst.replaceAll(s -> s.replace('a', 'A'));
        System.out.println(lst);
    }


    static void m2() {
        List<Integer> lst = getIntegers();
        lst.replaceAll(i->i*7);
        System.out.println(lst.removeIf(i->i%5==0));
        lst.forEach(System.out::println);
    }

    private static List<Integer> getIntegers() {
        return IntStream.rangeClosed(1, 5)
                        .mapToObj(i -> i)
                        .collect(toCollection(LinkedList::new));
    }

    static void m3(){
        List<Integer> lst = getIntegers();
        lst.replaceAll(null);  //NPE
    }

    static void m4(){
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");

        map.replaceAll((k, v) -> k + v);
        System.out.println(map);
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
