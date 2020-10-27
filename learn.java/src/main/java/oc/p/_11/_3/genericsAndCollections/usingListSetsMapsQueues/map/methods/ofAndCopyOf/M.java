package oc.p._11._3.genericsAndCollections.usingListSetsMapsQueues.map.methods.ofAndCopyOf;

import java.util.Map;

class M {

    void of(){
        final Map<Integer, Integer> map = Map.of(1, 1);

//        Map.of(1, 1, 2);  //CE
    }

    void copyOf(){
        final Map<Integer, Integer> of = Map.of(1, 1);
        final Map<Integer, Integer> copyOf = Map.copyOf(of);
    }

    void ofEntry(){
        final Map<Integer, Integer> map = Map.ofEntries(
                Map.entry(1, 1),
                Map.entry(2, 2));

        System.out.println(map);
    }


    public static void main(String[] args) {
        final M m = new M();

        m.ofEntry();
    }
}
