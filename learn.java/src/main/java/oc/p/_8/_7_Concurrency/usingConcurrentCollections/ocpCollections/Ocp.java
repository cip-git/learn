package oc.p._8._7_Concurrency.usingConcurrentCollections.ocpCollections;

import java.util.TreeMap;
import java.util.TreeSet;

interface Ocp {

    static TreeSet<Ocp> TREE_SET = new TreeSet <>();
    static TreeMap<Ocp, Ocp> TREE_MAP = new TreeMap <>();
}
