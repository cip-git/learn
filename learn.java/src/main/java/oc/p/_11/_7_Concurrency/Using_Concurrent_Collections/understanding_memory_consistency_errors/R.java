package oc.p._11._7_Concurrency.Using_Concurrent_Collections.understanding_memory_consistency_errors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class R {

    static void issue(){
        final var map = new HashMap<String, Integer>();

        m(map);
    }

    static void solution(){
        final var map = new ConcurrentHashMap<String, Integer>();

        m(map);
    }

    static void m(final Map<String, Integer> map){
        map.put("penguin", 1);
        map.put("flamingo", 2);

        for(var key: map.keySet()){
            System.out.println(map.remove(key));
        }
    }

    public static void main(String[] args) {
        issue();
//        solution();
    }
}
