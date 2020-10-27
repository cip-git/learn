package oc.p._8._3_GenericsAndCollections.additionInJava8.copyOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.javaClass.hierrarchy.methods.alphabet.C;

class CopyOf {

    static void m(){
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
//        l.add(null);

        final List<String> cp = List.copyOf(l);  //RE if l has null elements

//        cp.add("c");  //RE
//        cp.remove(0);  //RE
//        cp.set(0, "A");  //RE
    }

    public static void main(String[] args) {
        m();
    }
}
