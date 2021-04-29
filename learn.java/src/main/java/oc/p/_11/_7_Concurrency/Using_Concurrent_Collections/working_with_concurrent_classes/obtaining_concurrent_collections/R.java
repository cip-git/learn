package oc.p._11._7_Concurrency.Using_Concurrent_Collections.working_with_concurrent_classes.obtaining_concurrent_collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Unlike the
 * concurrent collections,
 * the synchronized collections also throw an exception
 * if they are modified within an iterator by a single thread.

 */
class R {

    static void m(){
        var map = new HashMap<String, Object>();

        map.put("penguin", 1);
        map.put("flamingo", 2);

        final Map<String, Object> synchronizedMap = Collections.synchronizedMap(map);

        for(var k: synchronizedMap.keySet()){
            final Object remove = synchronizedMap.remove(k);
            System.out.println(remove);
        }
    }

    public static void main(String[] args) {
        m();
    }
}
