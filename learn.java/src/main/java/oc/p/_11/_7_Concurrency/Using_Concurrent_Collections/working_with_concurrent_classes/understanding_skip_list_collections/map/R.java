package oc.p._11._7_Concurrency.Using_Concurrent_Collections.working_with_concurrent_classes.understanding_skip_list_collections.map;

import java.util.Map;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

class R {

    static Map<Integer, Integer> map = new ConcurrentSkipListMap<>();

    static {
        map.put(7, 7);
        map.put(5, 5);
        map.put(11, 11);
    }

    static void m(){
        map
                .keySet()
                .forEach(k -> System.out.println(map.remove(k)));
    }

    static void m2(){
        if(map instanceof NavigableMap){
            NavigableMap<Integer, Integer> nm =(NavigableMap<Integer, Integer>)map;

            final Map.Entry<Integer, Integer> firstEntry = nm.firstEntry();
            System.out.println(firstEntry); //

            final Map.Entry<Integer, Integer> lastEntry = nm.lastEntry();
            System.out.println(lastEntry);

            final Map.Entry<Integer, Integer> lowerEntry = nm.lowerEntry(12);  //(11, 11)
            System.out.println(lowerEntry);

            final Map.Entry<Integer, Integer> floorEntry = nm.floorEntry(11);//(11, 11)
            System.out.println(floorEntry);

            final Map.Entry<Integer, Integer> higherEntry = nm.higherEntry(7);  //(11, 11)
            System.out.println(higherEntry);

            final Map.Entry<Integer, Integer> ceilingEntry = nm.ceilingEntry(11);  //(11, 11)
            System.out.println(ceilingEntry);
        }
    }

    public static void main(String[] args) {
//        m();

        m2();
    }
}
