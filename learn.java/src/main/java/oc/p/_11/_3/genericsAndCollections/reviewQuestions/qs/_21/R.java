package oc.p._11._3.genericsAndCollections.reviewQuestions.qs._21;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class R {

    static void m(){
        var map = Map.of(1, 2, 3, 6);
        var list = List.copyOf(map.entrySet());

        final Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        final Set<Integer> integers = map.keySet();

        final List<Integer> one = List.of(8, 16, 2);
        var copy = List.copyOf(one);
        var copyOfCopy = List.copyOf(copy);
        var thirdCopy = new ArrayList<>(copyOfCopy);
    }
}
