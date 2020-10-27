package oc.p._11._3.genericsAndCollections.sortingData;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

class R3 {

    static void m(){
        final var l = List.of(3, 2, 1);
        final var l2 = List.copyOf(l);

//        Collections.sort(l);  //RE UnsupportedOperationException
//        Collections.sort(l2);  //RE UnsupportedOperationException

        System.out.println(l);
        System.out.println(l2);
    }

    public static void main(String[] args) {
        m();
    }
}
