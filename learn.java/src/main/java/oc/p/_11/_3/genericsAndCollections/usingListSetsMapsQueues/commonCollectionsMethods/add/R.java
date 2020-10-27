package oc.p._11._3.genericsAndCollections.usingListSetsMapsQueues.commonCollectionsMethods.add;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class R {

    final List<String> list;
    {
        list = IntStream
                .range(1, 10)
                .mapToObj(i -> "A: " + i)
                .collect(toList());
    }

    public static void main(String[] args) {
        final R r = new R();

//        r.m();
        r.m2();
    }

    void  m2(){
        list.forEach(list::add);  //ConcurrentModificationException
    }

    void m(){
        for(int i=0; i<list.size(); i++){
            list.add("a");
            System.out.println(list.size());
        }
    }
}
