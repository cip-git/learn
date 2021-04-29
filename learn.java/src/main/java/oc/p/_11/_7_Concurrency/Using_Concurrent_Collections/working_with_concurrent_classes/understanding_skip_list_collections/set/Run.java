package oc.p._11._7_Concurrency.Using_Concurrent_Collections.working_with_concurrent_classes.understanding_skip_list_collections.set;

import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

class Run {

    static Set<Integer> set = new ConcurrentSkipListSet<>();

    static {
        set.add(7);
        set.add(5);
        set.add(11);
    }

    static void m(){
        for(var i: set){
            final boolean remove = set.remove(i);
            System.out.println(remove);
        }
    }

    static void m2(){
        if(set instanceof NavigableSet){
            NavigableSet<Integer> ns = (NavigableSet<Integer>)set;

            final Integer lower = ns.lower(12);
            System.out.println(lower); //11

            final Integer floor = ns.floor(11);//11
            System.out.println(floor);

            final Integer higher = ns.higher(5); //7
            System.out.println(higher);

            final Integer ceiling = ns.ceiling(5);  //5
            System.out.println(ceiling);
        }
    }

    public static void main(String[] args) {
//        m();

        m2();
    }
}
