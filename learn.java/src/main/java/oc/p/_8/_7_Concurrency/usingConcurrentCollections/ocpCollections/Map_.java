package oc.p._8._7_Concurrency.usingConcurrentCollections.ocpCollections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

class Map_ {

    Map <Ocp, Ocp> map;
    SortedMap <Ocp, Ocp> sortedMap;
    NavigableMap <Ocp, Ocp> navigableMap;
    ConcurrentMap <Ocp, Ocp> concurrentMap;

    {
        map = new HashMap <>();
        map = new LinkedHashMap <>();
        map = new TreeMap <>();

        map = new ConcurrentHashMap <>();
        map = new ConcurrentSkipListMap <>();

        map = Collections.synchronizedMap(Ocp.TREE_MAP);
        map = Collections.synchronizedSortedMap(Ocp.TREE_MAP);
        map = Collections.synchronizedNavigableMap(Ocp.TREE_MAP);
    }

    {
        sortedMap = new TreeMap <>();

        sortedMap = new ConcurrentSkipListMap <>();

        sortedMap = Collections.synchronizedSortedMap(sortedMap);
    }

    {
        navigableMap = new TreeMap <>();

        navigableMap = new ConcurrentSkipListMap();

        navigableMap = Collections.synchronizedNavigableMap(navigableMap);
    }

    {
        concurrentMap = new ConcurrentHashMap <>();
        concurrentMap = new ConcurrentSkipListMap <>();
    }
}
