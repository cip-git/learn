package oc.p._11._7_Concurrency.Using_Concurrent_Collections.working_with_concurrent_classes.understanding_copy_on_write_collections.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class R {

    static List<Integer> lst = new CopyOnWriteArrayList<>();

    static {
        lst.add(7);
        lst.add(5);
        lst.add(11);
    }

    static void m(){
        lst.forEach(e -> Integer.valueOf(e.intValue()));
        System.out.println(lst);

        lst.forEach(lst::add);
        System.out.println(lst);

        lst.forEach(lst::remove);
        System.out.println(lst);
    }

    public static void main(String[] args) {
        m();
    }
}
