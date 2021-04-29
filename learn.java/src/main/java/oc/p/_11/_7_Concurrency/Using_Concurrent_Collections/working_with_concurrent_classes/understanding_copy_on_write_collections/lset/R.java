package oc.p._11._7_Concurrency.Using_Concurrent_Collections.working_with_concurrent_classes.understanding_copy_on_write_collections.lset;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class R {

    static Set<Integer> set = new CopyOnWriteArraySet<>();

    static {
        set.add(7);
        set.add(5);
        set.add(11);
    }

    static void m(){
        set.forEach(e -> Integer.valueOf(e.intValue()));
        System.out.println(set);

        set.forEach(e -> set.add(e + 10));
        System.out.println(set);

        set.forEach(set::remove);
        System.out.println(set);
    }

    public static void main(String[] args) {
        m();
    }
}
