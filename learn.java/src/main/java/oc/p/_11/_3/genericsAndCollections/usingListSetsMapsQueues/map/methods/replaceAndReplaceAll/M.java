package oc.p._11._3.genericsAndCollections.usingListSetsMapsQueues.map.methods.replaceAndReplaceAll;

import java.util.HashMap;
import java.util.Map;

class M {

    Map<Integer, Integer> map = new HashMap<>();
    {
        map.put(1, 1);
        map.put(2, 2);
    }

    void replace(){
        System.out.println(map.replace(2, 22));

        System.out.println(map.replace(3, 33));

        System.out.println(map);
    }

    void replaceAll() {
        map.replaceAll((k, v) -> k * v * 10);

        System.out.println(map);

        map.replaceAll((k, v) -> null);
        System.out.println(map);
    }

    public static void main(String[] args) {
        final M m = new M();

//        m.replace();
        m.replaceAll();
    }
}
