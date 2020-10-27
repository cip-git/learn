package oc.p._8._3_GenericsAndCollections.test;

import static utils.print.Print.print;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Q {

    static void q15(){
        Comparator<Integer> c = (o, o2) -> o2-o;
        List<Integer> list = Arrays.asList(5, 4, 7, 1);
        Collections.sort(list, c);

        print(list);
        print(Collections.binarySearch(list, 1));
    }

    static void q24(){
        Set<String> set = new HashSet<>();
        set.add("lion");
        set.add("tiger");
        set.add("bear");

        set.forEach(s -> System.out.println(s));
        set.forEach((s) -> System.out.println(s));
        set.forEach(System.out::println);
    }

    static void m(){
        Map<Integer, String> map = new HashMap<>();
        map.forEach((k, v) -> {});
        map.forEach((Integer k, String s) -> {});
     }


    public static void main(String[] args) {
        q15();
    }
}
