package oc.p._11._3.genericsAndCollections.usingListSetsMapsQueues.commonCollectionsMethods.remove;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

class R {
    final List<String> list;

    {
        list = IntStream
                .rangeClosed(1, 10)
                .mapToObj(i -> "A " + i)
                .collect(toList());
    }

    public static void main(String[] args) {
        final R r = new R();

//        r.m();
//        r.m2();
//        r.m3();
        r.m4();  //ConcurrentModificationException
    }


    //forEach
    void m4(){
        list.forEach(list::remove);  //ConcurrentModificationException
    }

    //enhanced for loop
    void m3(){
        for(String s: list){
            list.remove(s);  //ConcurrentModificationException
        }
    }

    //remove by elem
    void m2() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " -> " + list.remove(list.get(i)));
            System.out.println(list.size());
        }
        System.out.println(list);
    }

    //remove by index
    void m() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " -> " + list.remove(0));
        }
        System.out.println(list);
    }
}
